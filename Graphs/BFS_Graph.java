package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Graph {
    static ArrayList<Integer> BFSGraph(int V, ArrayList<Integer>[] adj){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V];
        q.add(0);
        visited[0]=1;
        ArrayList<Integer> ans=new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);
            for (int j=0;j<adj[node].size();j++){
                if (visited[adj[node].get(j)]==0){
                    visited[adj[node].get(j)]=1;
                    q.add(adj[node].get(j));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=4;
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
        System.out.println(BFSGraph(V,adj));
    }
}
