package Graphs;

import java.util.*;

/*
    Find the bridge edges in a graph
    Bridge Edge -> Any edge is termed as bridge edge if by cutting that edge, the graph become disconnected
*/

public class bridges_in_a_graph {
    static int count = 0; //A counter that tracks the discovery time and lowest node possible to reach from current node(initially)

    //Create Adjacency List
    static ArrayList<ArrayList<Integer>> createGraph(int[][] connections, int V)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for (int i=0;i<V;i++)
            for (int j=0;j<V;j++)
                if (i != j && connections[i][j] == 1)
                    adj.get(i).add(j);

        return adj;
    }
    static ArrayList<ArrayList<Integer>> bridge(int[][] connections, int V)
    {
        ArrayList<ArrayList<Integer>> adj = createGraph(connections,V); //create Adjacency List
        int[] disc = new int[V]; //Tracks discovery time
        int[] low = new int[V]; //Tracks Lowest node possible to reach
        boolean[] visited = new boolean[V]; //Tracks the nodes those are already visited
        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();

        DFS(0,adj,disc,low,visited,bridges,-1); //Call DFS to find the bridges
        return bridges;
    }
    static void DFS(int node, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, boolean[] visited, ArrayList<ArrayList<Integer>> bridges, int parent)
    {
        disc[node] = low[node] = count; //Initially discovery time and low time are same for all nodes
        visited[node] = true; //Mark the node as visited

        for (int i=0;i<adj.get(node).size();i++)
        {
            int neigh = adj.get(node).get(i); //Take the current neighbour

            if (neigh == parent) //If neighbour is parent then no further check
                continue;
            else if (visited[neigh]) //If neighbour is already visited then update the low of node
                low[node] = Math.min(low[node],low[neigh]); //Low of node is minimum of low of node and low of neighbour
            else //If neighbour is not visited
            {
                count++; //Increment the count for neighbour
                DFS(neigh,adj,disc,low,visited,bridges,node); //Call DFS for neighbour
                if (low[neigh] > disc[node]) //After DFS check that, is the lowest possible node reachable from neighbour is greater than discovery time of current node i.e. from neighbour we can't reach any node before current node
                {
                    //Store info of bridge
                    ArrayList<Integer> bridgeEdge = new ArrayList<>();
                    bridgeEdge.add(node);
                    bridgeEdge.add(neigh);
                    bridges.add(bridgeEdge);
                }
                low[node] = Math.min(low[node],low[neigh]); //After that update the low of node with minimum of low node and low of neighbour
            }
        }
    }
    public static void main(String[] args) {
        int[][] connections = {
                {1,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,1,1,1,0,1},
                {0,0,1,1,1,0},
                {0,0,0,1,1,1},
                {0,0,1,0,1,1}
        };
        int V = 6;
        System.out.println(bridge(connections,V));
    }
}
