package Graphs;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.util.*;

//There are information about n cities and m roads - return any valid way of a round trip
public class round_trip {
    static List<List<Integer>> createGraph(int[][] info, int V)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for (int[] ints : info) {
            adj.get(ints[0]-1).add(ints[1]-1);
            adj.get(ints[1]-1).add(ints[0]-1);
        }
        return adj;
    }
    static void roundTrip(int node, List<List<Integer>> adj, List<Integer> path, boolean[] visited, int parent)
    {
        visited[node] = true;
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(adj.get(node).get(i) == parent)
                continue;
            else if(visited[adj.get(node).get(i)])
            {
                path.add(adj.get(node).get(i));
            }
            roundTrip(adj.get(node).get(i),adj,path,visited,node);
        }
    }
    public static void main(String[] args) {
        int[][] info = {
                {1, 3},
                {1, 2},
                {5, 3},
                {1, 5},
                {2, 4},
                {4, 5}
        };
        int V = 5;
        List<List<Integer>> adj = createGraph(info,V);
        List<Integer> roundTripPath = new ArrayList<>();
        boolean[] visited = new boolean[V];
        roundTrip(0,adj,roundTripPath,visited,-1);
        System.out.println(roundTripPath);
    }
}
