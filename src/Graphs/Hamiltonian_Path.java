package Graphs;

import java.util.ArrayList;

public class Hamiltonian_Path {
    static int count = 0;
    static ArrayList<ArrayList<Integer>> createGraph(int[][] edges, int V)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for (int i=0;i<V;i++)
            for(int j=0;j<V;j++)
                if(i != j && edges[i][j] == 1)
                    adj.get(i).add(j);

        return adj;
    }
    static boolean isHamiltonianPath(int[][] edges, int V)
    {
        //Create Adjacency List
        ArrayList<ArrayList<Integer>> adj = createGraph(edges,V);

        boolean[] visited = new boolean[V];

        for (int i=0;i<V;i++)
            if(!visited[i] && DFS(i,adj,visited,V))
                return true;

        return false;
    }
    static boolean DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int V)
    {
        visited[node] = true;
        count++;

        if (count == V)
            return true;

        for (int i=0;i<adj.get(node).size();i++)
        {
            if(!visited[adj.get(node).get(i)] && DFS(adj.get(node).get(i),adj,visited,V))
                return true;
        }
        visited[node] = false;
        count--;
        return false;

    }
    public static void main(String[] args) {
        int[][] edges = {
                {1,1,0,0,1},
                {1,1,1,0,0},
                {1,1,1,1,1},
                {0,1,1,1,1},
                {1,1,0,1,1}
        };
        int V = 5;
        System.out.println(isHamiltonianPath(edges,V));
    }
}
