package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detect_cycle_in_a_directed_graph_DCG {
    static ArrayList<ArrayList<Integer>> makeAdjacencyList(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        //Creating new arraylist for each vertex
        for (int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        //Making adjacency List
        for (int i=0;i<edges.length;i++)
            for (int j=0;j<edges[0].length;j++)
                if (i!=j && edges[i][j]==1)
                    adjList.get(i).add(j);

        return adjList;
    }
    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //find in-degree of ech vertex
        int[] inDeg = new int[V];
        for (int i=0;i<V;i++)
            for(int j=0;j<adj.get(i).size();j++)
                inDeg[adj.get(i).get(j)]++;

        Queue<Integer> q = new LinkedList<>();
        //If inDeg[i]==0 i.e. No incoming edge is falling on that vertex
        for (int i=0;i<V;i++)
            if (inDeg[i]==0)
                q.add(i);

        int count=0;
        while (!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            count++;
            for (int i=0;i<adj.get(node).size();i++)
            {
                inDeg[adj.get(node).get(i)]--; //Decrease in-degree of each vertex connected with node by 1
                if (inDeg[adj.get(node).get(i)]==0)  //if in-degree=0 push that vertex to queue
                    q.add(adj.get(node).get(i));
            }
        }
        return count!=V;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {1,1,0,0},
                {0,1,1,0},
                {0,0,1,1},
                {0,0,0,1}
        };
        ArrayList<ArrayList<Integer>> adjacencyList = makeAdjacencyList(V,edges);
        System.out.println(adjacencyList);;
        System.out.println(isCycle(V,adjacencyList));
    }
}
