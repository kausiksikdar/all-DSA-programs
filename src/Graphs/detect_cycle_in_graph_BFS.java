package Graphs;

import java.util.*;

public class detect_cycle_in_graph_BFS {

    static boolean BFS(int node, ArrayList<Integer>[] adj, boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        visited[node] = true;
        q.add(new int[]{node,-1});
        while (!q.isEmpty()){
            int data = q.peek()[0];
            int parent = q.peek()[1];
            q.remove();
            for (int j=0;j<adj[data].size();j++){
                if (adj[data].get(j)==parent) continue;
                if (visited[adj[data].get(j)]) return true;
                visited[adj[data].get(j)] = true;
                q.add(new int[]{adj[data].get(j),node});
            }
        }
        return false;
    }
    static boolean detectCycle(int V, ArrayList<Integer>[] adj){
        boolean[] visited = new boolean[V];
        for (int j=0;j<V;j++){
            if (!visited[j] && BFS(j,adj,visited)) return true;
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
