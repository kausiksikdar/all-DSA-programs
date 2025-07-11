package Graphs;

import java.util.*;

//Question -> Find the shortest distance of each node taking source node as 0
public class shortest_path_in_undirected_graph {
    static int[] findShortestDistance(int[][] edges)
    {
        int n = edges.length;
        int m = edges[0].length;

        //Creation of graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(i != j && edges[i][j] == 1)
                    adj.get(i).add(j);

        //Find the shortest distance
//        int[] dist = new int[n];
//        Arrays.fill(dist,-1);
//        boolean[] visited = new boolean[n];
//
//        Queue<Integer> q = new LinkedList<>();
//        int level = 0;
//        q.offer(0);
//        visited[0] = true;
//
//        while (!q.isEmpty())
//        {
//            int s = q.size();
//            while (s-->0) {
//                int node = q.poll();
//                dist[node] = level;
//
//                for(int i=0;i<adj.get(node).size();i++)
//                {
//                    if(!visited[adj.get(node).get(i)])
//                    {
//                        visited[adj.get(node).get(i)] = true;
//                        q.offer(adj.get(node).get(i));
//                    }
//                }
//            }
//            level++;
//        }
//        return dist;

        //IIf we want to print the path for a specific node
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty())
        {
                int node = q.poll();

                for(int i=0;i<adj.get(node).size();i++)
                {
                    if(!visited[adj.get(node).get(i)])
                    {
                        visited[adj.get(node).get(i)] = true;
                        parent[adj.get(node).get(i)] = node;
                        q.offer(adj.get(node).get(i));
                    }
                }
        }
        int dest = 8;
        List<Integer> path = new ArrayList<>();
        path.add(dest);
        while (dest != -1)
        {
            path.add(parent[dest]);
            dest = parent[dest];
        }
        Collections.reverse(path);
        path.remove(0);
        System.out.println(path);
        return new int[]{};
    }
    public static void main(String[] args) {
        int[][] edges = {
                        {1,1,1,0,0,0,0,0,0,0,0},
                        {1,1,0,0,0,1,0,0,0,0,0},
                        {1,0,1,1,1,0,0,0,0,0,0},
                        {0,0,1,1,1,0,0,1,0,0,0},
                        {0,0,1,1,0,0,0,0,1,0,0},
                        {0,1,0,0,0,0,1,0,0,0,0},
                        {0,0,0,0,0,1,0,0,1,0,0},
                        {0,0,0,1,0,0,0,0,1,0,0},
                        {0,0,0,0,1,0,1,1,0,0,0},
                        {0,0,0,0,0,0,0,0,0,1,1},
                        {0,0,0,0,0,0,0,0,0,1,1}
        };
        int[] shortestDistance = findShortestDistance(edges);

        for(int i=0;i<shortestDistance.length;i++)
            System.out.print(shortestDistance[i]+" ");
    }
}
