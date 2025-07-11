package Graphs;
/*
  Dijkstra's algorithm -> It is an algorithm designed to find the shortest path from a single node(source) to all other nodes
  It is undirected graph having nodes with weight, we need to find the shortest path i.e. a path from source to
  dest(all other nodes) having minimum sum of weights.

  so here we keep track of distance from nodes from source and keep updating that with minimum value
  we always choose the minimum distance at each iteration(with the help od PQ) and try to find whether there
  is any other way to get any distance lesser than the current distance
  SC = O(V+E)
  TC = O(ElogE)
 */
import java.util.*;

public class dijkstra_algo {
    static ArrayList<ArrayList<ArrayList<Integer>>> createGraph(int[][][] edges, int n)
    {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
            for(int j=0;j<edges[i].length;j++)
            {
                 ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(edges[i][j][0],edges[i][j][1]));
                 edge.add(temp);
            }
            adj.add(edge);
        }
        return adj;
    }
    static int[] singleSourceShortestPath(ArrayList<ArrayList<ArrayList<Integer>>> adj, int n, int s)
    {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] explored = new boolean[n];

        pq.add(new ArrayList<>(Arrays.asList(0,s)));
        dist[s] = 0;
        explored[s] = true;

        while (!pq.isEmpty())
        {
            ArrayList<Integer> top = pq.poll();
            int edge = top.get(1);

            explored[edge] = true;
            for(int i=0;i<adj.get(edge).size();i++)
            {
                int neighbour = adj.get(edge).get(i).get(0);
                int weight = adj.get(edge).get(i).get(1);

                if(!explored[neighbour] && dist[edge]+weight < dist[neighbour])
                {
                    dist[neighbour] = dist[edge]+weight;
                    pq.add(new ArrayList<>(Arrays.asList(dist[neighbour],neighbour)));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][][] edges = {
                {{1, 6}, {2, 2}},
                {{0, 6}, {2, 3}, {3, 7}},
                {{0, 2}, {1, 3}, {4, 4}},
                {{1, 7}, {5, 2}, {4, 5}},
                {{2, 4}, {3, 5}, {5, 9}},
                {{3, 2}, {4, 9}}
        };
        int n = edges.length;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(edges,n);
        int[] dist = singleSourceShortestPath(adj,n,0);
        for(int j:dist)
            System.out.print(j + " ");
    }
}
