package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class detect_cycle_in_graph_DFS {
    static boolean DFS(int node, int parent, ArrayList<Integer>[]adj, boolean[] visited){
        //Standing any specific node first mark it visited
        visited[node]=true;
        //Then check for every edges connected to that node that is that node make a cycle or not
        for (int j = 0; j< adj[node].size(); j++){
            //if the node is parent that means the present node is coming from that node so ignore that as does not make any cycle
            if (adj[node].get(j)==parent) continue;
            //if the node is not parent and still visited that means we got a cycle
            if (visited[adj[node].get(j)]) return true;
            //if above two conditions is not satisfied that means we have to check next
            if (DFS(adj[node].get(j),node,adj,visited)) return true;
        }
        return false;
    }
    static boolean detectCycle(int V, ArrayList<Integer>[]adj){
        boolean[] visited = new boolean[V]; //visited array is created as to check every element of graph visited or not as graph may be disconnected
        for (int j=0;j<V;j++){
            /*if the present vertex is not visited that means it is disconnected node
            This statement helps to hop to disconnected node*/
            if (!visited[j] && DFS(j,-1,adj,visited)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int V=3;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int j=0;j<adj.length;j++){
            adj[j]=new ArrayList<>();
            System.out.println("Enter the total no. of edges in "+j);
            int n = sc.nextInt();
            System.out.println("Enter the edges one by one: ");
            int k=0;
            while (k<n){
                int ip = sc.nextInt();
                adj[j].add(ip);
                k++;
            }
        }
        System.out.println();
        System.out.println(detectCycle(V,adj));
    }
}
