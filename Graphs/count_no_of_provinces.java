package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class count_no_of_provinces {
    static List<List<Integer>> makeAdjacencyList(int V, int[][] isConnected)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<isConnected.length;i++)
            for(int j=0;j<isConnected[0].length;j++)
                if(i!=j && isConnected[i][j]==1)
                    adj.get(i).add(j);

        return adj;
    }
    static void BFS(int node, List<List<Integer>> adj, boolean[] visited)
    {
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty())
        {
            int curr = q.peek();
            q.remove();

            for(int j=0;j<adj.get(curr).size();j++)
            {
                if(!visited[adj.get(curr).get(j)])
                {
                    visited[adj.get(curr).get(j)] = true;
                    q.add(adj.get(curr).get(j));
                }
            }
        }
    }
    static int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adj = makeAdjacencyList(V,isConnected);

        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                count++;
                BFS(i,adj,visited);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] isConnected = { {1,1,0},
                                {1,1,0},
                                {0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
    }
}
