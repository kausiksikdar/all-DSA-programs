package Graphs;

import java.util.*;

/*
    SCC -> Strongly Connected Component, is a subpart of a graph where each node connects with other node of that subpart whereas
    that subpart is connected with the main graph by a bridge edge

    Find the total number of SCC for a particular graph

    Here we use Kosaraju Algorithm to find the SCC
    Algorithm :-
    1. Find the Topological Sort
    2. Edge reversal should be done
    3. Apply DFS finally to get the total SCC
*/
public class SCC_Kosaraju_algo {
    //Create the Adjacency List
    static ArrayList<ArrayList<Integer>> createGraph(int[][] edges, int V)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }
        return adj;
    }
    static int SCC(int[][] edges, int V)
    {
        ArrayList<ArrayList<Integer>> adj = createGraph(edges,V);
        //Topological Sort to maintain the order of traversal after edge reversal
        Stack<Integer> st = new Stack<>(); //To hold the topological sort
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
            if (!visited[i])
                topologicalSort(i,visited,st,adj);

        Arrays.fill(visited,false); //Mark the visited array false to re-use
        //Edge reversal
        ArrayList<ArrayList<Integer>> adjReversed = new ArrayList<>();
        for (int i=0;i<V;i++)
            adjReversed.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjReversed.get(v).add(u);
        }

        int SCC = 0; //Tracks the number of SCC
        //Finally apply DFS to find SCC following the topological sort order
        while (!st.empty())
        {
            int node = st.peek();
            st.pop();

            if(!visited[node])
            {
                SCC++;
                DFS(node,adjReversed,visited);
            }
        }
        return SCC;
    }
    static void DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        visited[node] = true;

        for(int i=0;i<adj.get(node).size();i++)
        {
            if (!visited[adj.get(node).get(i)])
                DFS(adj.get(node).get(i),adj,visited);
        }
    }
    static void topologicalSort(int node, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = true;
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(!visited[adj.get(node).get(i)])
                topologicalSort(adj.get(node).get(i),visited,st,adj);
        }
        st.push(node);
    }
    public static void main(String[] args) {
        int [][] edges = {
                {1,0},{2,1},{3,2},{0,3},{2,11},{11,10},{10,9},{9,11},{9,8},{8,4},{7,4},{6,7},{4,6},{4,5},{5,6}
        };
        int V = 12;
        System.out.println(SCC(edges,V));
    }
}