package Graphs;
/*
    Bellman Ford Algorithm -> It is also a single source the shortest path algo similar to dijkstra algo
    but compatible with -ve weight, also can detect -ve cycle

    here we relax edges for n-1 times for getting the min val of distance from source out of all possible distances
    here we relax edges n-1 times as edges info is jumbled so to get the min dist we need to iterate all the
    n-1 iterations as possible ways to reach n-1 nodes from source is n-1

    to detect -ve loop, we need one more iteration, if the dist[node] change again after n-1 iteration that means
    there is -ve cycle present, so there is no shortest path exist for the graph
    SC = O(V), TC = O(VE)
*/
import java.util.*;

public class bellman_ford_algorithm {
    static int[] singleSourceShortestPathWithNegativeWeight(int[][] edges, int n, int s) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int[] edge : edges) {
                int source = edge[0];
                int dest = edge[1];
                int weight = edge[2];

                if (dist[source] == Integer.MAX_VALUE)
                    continue;

                if (dist[source] + weight < dist[dest]) {
                    dist[dest] = dist[source] + weight;
                    flag = true;
                }
            }
            if (!flag)
                return dist;
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            if (dist[source] + weight < dist[dest])
                return new int[]{-1};
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {2, 4, 2},
                {3, 4, -2},
                {2, 3, -3},
                {0, 2, 5},
                {1, 3, 1},
                {0, 1, 3}
        };
        int n = 5;
        int s = 0;
        int[] dist = singleSourceShortestPathWithNegativeWeight(edges, n, s);
        for (int j : dist)
            System.out.print(j + " ");
    }
}
