package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_Graph {
    static void DFSGraph(int node, ArrayList<Integer>[] adj, int[] visited){
        visited[node]=1;
        System.out.print(node+" ");
        for (int j=0;j<adj[node].size();j++){
            if (visited[adj[node].get(j)]==0){
                DFSGraph(adj[node].get(j),adj,visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=8;
        ArrayList<Integer>[] adj=new ArrayList[V];
        for (int j=0;j< adj.length;j++){
            adj[j]=new ArrayList<>();
        }
        for (int j=0;j<V;j++){
            System.out.println("The present Vertex is: "+j);
            System.out.println("Please Enter the total no of edges: ");
            int n= sc.nextInt();
            for (int k=0;k<n;k++) {
                int ip=sc.nextInt();
                adj[j].add(ip);
            }
        }
        int[] visited=new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        DFSGraph(adj[0].get(0),adj,visited                                );

    }
}
