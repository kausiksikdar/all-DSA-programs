package Graphs;

import java.util.*;

public class  prims_algo{

    static class Edge {
        int weight, node, parent;

        Edge(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }

    static int minCostToCoverAllNodes(List<List<int[]>> adjList, int V) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        int totalCost = 0;

        // Priority queue to store edges sorted by weight
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // Start from node 0
        pq.add(new Edge(0, 0, -1));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int weight = current.weight;
            int node = current.node;
            int par = current.parent;

            // Skip if already visited
            if (visited[node]) continue;

            // Mark as visited and add to MST
            visited[node] = true;
            parent[node] = par;
            totalCost += weight;

            // Add all adjacent edges to priority queue
            for (int[] edge : adjList.get(node)) {
                int adjNode = edge[0];
                int edgeWeight = edge[1];

                if (!visited[adjNode]) {
                    pq.add(new Edge(edgeWeight, adjNode, node));
                }
            }
        }

        // Print MST edges
        System.out.println("MST Edges:");
        for (int i = 0; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println("Edge: " + parent[i] + " - " + i);
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int V = 9;

        // Create adjacency list representation
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges (undirected graph)
        addEdge(adjList, 0, 1, 4);
        addEdge(adjList, 0, 7, 8);
        addEdge(adjList, 1, 2, 8);
        addEdge(adjList, 1, 7, 11);
        addEdge(adjList, 2, 3, 7);
        addEdge(adjList, 2, 8, 2);
        addEdge(adjList, 3, 4, 9);
        addEdge(adjList, 3, 5, 14);
        addEdge(adjList, 4, 5, 10);
        addEdge(adjList, 5, 6, 2);
        addEdge(adjList, 6, 7, 1);
        addEdge(adjList, 6, 8, 6);
        addEdge(adjList, 7, 8, 7);

        System.out.println("Minimum Cost: " + minCostToCoverAllNodes(adjList, V));
    }

    // Helper method to add undirected edges
    static void addEdge(List<List<int[]>> adjList, int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }
}