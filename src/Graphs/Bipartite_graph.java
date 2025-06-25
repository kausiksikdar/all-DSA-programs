package Graphs;
import java.util.*;public class Bipartite_graph {
    static List<List<Integer>> createAdjacency(int[][] edges, int V)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(i != j && edges[i][j] == 1)
                {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
    static boolean checkBipartite(List<List<Integer>> adj, int node, int[] color)
    {
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(color[adj.get(node).get(i)] == -1)
            {
                color[adj.get(node).get(i)] = (color[i]+1)%2;
                if(checkBipartite(adj, adj.get(node).get(i), color))
                    return true;
            }
            else if(color[adj.get(node).get(i)] == color[i])
                return true;
        }
        return false;
    }
    static boolean isBipartite(List<List<Integer>> adj, int V)
    {
        //Using Depth-First Search
//        int[] color = new int[V];
//        Arrays.fill(color,-1);
//        for(int i=0;i<V;i++)
//        {
//            if(color[i] == -1)
//            {
//                color[i] = 0;
//                if (!checkBipartite(adj, i, color))
//                    return false;
//            }
//        }
//        return true;

        //Using Breadth-First Search
        int[] color = new int[V];
        Arrays.fill(color,-1);
        Queue<Integer> holdNodes = new LinkedList<>();

        for(int i=0;i<V;i++)
        {
            if(color[i] == -1)
            {
                color[i] = 0; //assign the color
                holdNodes.add(i); //add to the queue

                while(!holdNodes.isEmpty()) //check for its adjacent nodes
                {
                    int currNode = holdNodes.poll(); //pop the current element

                    for(int j=0;j<adj.get(currNode).size();j++) //iterate over adjacent elements
                    {
                        if(color[adj.get(currNode).get(j)] == -1) //if color is not assigned
                        {
                            color[adj.get(currNode).get(j)] = (color[currNode] + 1) % 2; //assign color opposite to the current node
                            holdNodes.add(adj.get(currNode).get(j)); //now add to queue for further check
                        }
                        else if(color[adj.get(currNode).get(j)] == color[currNode]) //if we got same color as previous node
                            return false; //that means it is not a bipartite graph
                    }
                }
            }
        }
        return true; //if nothing returns from loop that means it is a bipartite graph
    }
    public static void main(String[] args) {
        int[][] edges = {
                {1,1,0,0,0,0,0,0,0},
                {1,1,1,0,0,0,0,0,0},
                {0,1,1,1,1,0,0,0,0},
                {0,0,1,0,0,1,0,0,0},
                {0,0,1,0,0,0,1,0,0},
                {0,0,0,1,0,0,0,1,0},
                {0,0,0,0,1,0,0,1,0},
                {0,0,0,0,0,1,1,1,1},
                {0,0,0,0,0,0,0,1,1}
        };
         int V = 9;
        List<List<Integer>> adj = createAdjacency(edges,V);
        System.out.println(isBipartite(adj,V));
    }
}
