package Graphs;

/*
* Topological Sort -> is a Sorting technique in which, we sort the nodes on the basis of their priority
* Very efficient when it comes to prioritise nodes to perform some specific operation */

import java.util.*;

public class topological_sort_dfs_and_khan_algorithm {
    static void DFS(int node, ArrayList<ArrayList<Integer>> List, Stack<Integer> stack, boolean[] visited)
    {
        visited[node]=true;

        for (int i=0;i<List.get(node).size();i++)
            if (!visited[List.get(node).get(i)])
                DFS(List.get(node).get(i),List,stack,visited);

        stack.push(node);
    }
    static ArrayList<Integer> topoSortUsingDFS(int V, ArrayList<ArrayList<Integer>> List)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<V;i++)
            if (!visited[i])
                DFS(i,List,stack,visited);

        ArrayList<Integer> answer = new ArrayList<>();
        while (!stack.empty())
        {
            answer.add(stack.peek());
            stack.pop();
        }
        return answer;
    }
    //Khan's Algorithm
    static ArrayList<Integer> topoSortUsingBFS(int V, ArrayList<ArrayList<Integer>> adjacencyList)
    {
      int[] inDeg = new int[V];

      for (int i=0;i<V;i++)
          for (int j=0;j<adjacencyList.get(i).size();j++)
              inDeg[adjacencyList.get(i).get(j)]++;

        Queue<Integer> q = new LinkedList<>();

        for (int i=0;i<V;i++)
            if (inDeg[i]==0)
                q.add(i);

        ArrayList<Integer> answer = new ArrayList<>();

        while (!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            answer.add(node);

            for (int i=0;i<adjacencyList.get(node).size();i++)
            {
                inDeg[adjacencyList.get(node).get(i)]--;

                if (inDeg[adjacencyList.get(node).get(i)]==0)
                    q.add(adjacencyList.get(node).get(i));

            }
        }
        return answer;
    }
    static ArrayList<ArrayList<Integer>> adjacencyList(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i=0;i<V;i++)
        {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++)
        {
            for (int j=0;j<edges[0].length;j++)
            {
                if (i!=j && edges[i][j]==1)
                {
                    adjacencyList.get(i).add(j);
                }
            }
        }
        return adjacencyList;
    }
    public static void main(String[] args) {
        int V=7;
        int[][] edges = {
                {1,1,1,0,0,0,0},
                {0,1,0,1,1,0,0},
                {0,0,1,0,0,0,0},
                {0,0,0,1,1,0,0}                                                                  ,
                {0,0,0,0,1,0,0},
                {0,0,0,0,1,1,1},
                {0,0,0,1,0,0,1}
        };
        ArrayList<ArrayList<Integer>> List = adjacencyList(V,edges);
        System.out.println(List);
        System.out.println(topoSortUsingDFS(V,List));
        System.out.println(topoSortUsingBFS(V,List));
    }
}
