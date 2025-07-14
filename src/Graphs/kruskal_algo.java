package Graphs;

import java.util.*;

class DisjointSet
{
    int[] parent;
    int[] rank;
    DisjointSet(int V)
    {
        parent = new int[V];

        for(int j=0;j<V;j++)
            parent[j] = j;

        rank = new int[V];
    }
    int findParent(int u)
    {
        if(u == parent[u])
            return u;

        return parent[u] = findParent(parent[u]);
    }
    void unionByRank(int u, int v)
    {
        int par_u = findParent(u);
        int par_v = findParent(v);

        if(rank[par_u] > rank[par_v])
            parent[par_v] = par_u;
        else if(rank[par_u] < rank[par_v])
            parent[par_u] = par_v;
        else
        {
            parent[par_v] = par_u;
            rank[par_u]++;
        }
    }
}
public class kruskal_algo {
    static class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    static int spanningTree(List<List<int[]>> adjList, int V)
    {
        DisjointSet ds = new DisjointSet(V);
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a,b)->a.wt-b.wt);
        int[] tree = new int[V];

        for(int i=0;i<adjList.size();i++)
        {
            for(int j=0;j<adjList.get(i).size();j++)
            {
                pq.add(new Edge(i,adjList.get(i).get(j)[0],adjList.get(i).get(j)[1]));
            }
        }

        int totalCost = 0;
        int totalEdges = 0;
        while(!pq.isEmpty())
        {
            Edge top = pq.poll();
            int u = top.u;
            int v = top.v;
            int wt = top.wt;

            if(ds.findParent(u) != ds.findParent(v))
            {
                tree[v] = u;
                totalCost+=wt;
                ds.unionByRank(u,v);
            }
            if(totalEdges == V-1)
                break;
        }
        for(int i=0;i<tree.length;i++)
            System.out.println("Edges: " + i + " " + tree[i]);

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

        System.out.println("Minimum Cost: " + spanningTree(adjList, V));
    }
    // Helper method to add undirected edges
    static void addEdge(List<List<int[]>> adjList, int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }
}
