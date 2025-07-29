package Graphs;

import java.util.*;

public class Articulation_point {

/*
    Find the Articulation Points in a graph
    Articulation Points -> Any Node is termed as Articulation Point if by removing that Node, the graph become disconnected
*/

        static int count = 0; //A counter that tracks the discovery time and lowest node possible to reach from current node(initially)

        //Create Adjacency List
        static ArrayList<ArrayList<Integer>> createGraph(int[][] connections, int V)
        {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i=0;i<V;i++)
                adj.add(new ArrayList<>());

            for (int i=0;i<V;i++)
                for (int j=0;j<V;j++)
                    if (i != j && connections[i][j] == 1)
                        adj.get(i).add(j);

            return adj;
        }
        static ArrayList<Integer> articulationPoint(int[][] connections, int V)
        {
            ArrayList<ArrayList<Integer>> adj = createGraph(connections,V); //create Adjacency List
            int[] disc = new int[V]; //Tracks discovery time
            int[] low = new int[V]; //Tracks Lowest node possible to reach
            boolean[] visited = new boolean[V]; //Tracks the nodes those are already visited
            boolean[] artpt = new boolean[V]; //Tracks the nodes which are articulation point
            ArrayList<Integer> articulationPoints = new ArrayList<>();

            DFS(0,adj,disc,low,visited,-1,artpt); //Call DFS to find the articulation points

            //Store the Articulation points in a list
            for (int i=0;i<V;i++)
                if (artpt[i])
                    articulationPoints.add(i);

            return articulationPoints;
        }
        static void DFS(int node, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, boolean[] visited, int parent, boolean[] artpt)
        {
            disc[node] = low[node] = count; //Initially discovery time and low time are same for all nodes
            visited[node] = true; //Mark the node as visited
            int child = 0; //Tracks the number of child of the current node

            for (int i=0;i<adj.get(node).size();i++)
            {
                int neigh = adj.get(node).get(i); //Take the current neighbour

                if (neigh == parent) //If neighbour is parent then no further check
                    continue;
                else if (visited[neigh]) //If neighbour is already visited then update the low of node
                    low[node] = Math.min(low[node],disc[neigh]); //Low of node is minimum of low of node and low of neighbour
                else //If neighbour is not visited
                {
                    count++; //Increment the count for neighbour
                    child++; //Increment the number of child
                    DFS(neigh,adj,disc,low,visited,node,artpt); //Call DFS for neighbour
                    if (low[neigh] >= disc[node] && parent != -1) //After DFS check that, is the lowest possible node reachable from neighbour is greater than discovery time of current node i.e. from neighbour we can't reach any node before current node
                    {
                        //Store info of articulation point
                        artpt[node] = true;
                    }
                    low[node] = Math.min(low[node],low[neigh]); //After that update the low of node with minimum of low node and low of neighbour
                }
            }
            //Starting Node(parent == -1) is only considered as articulation point when it has more than one child, otherwise it is not considered as articulation point
            if (child > 1 && parent == -1)
                artpt[node] = true;
        }
        public static void main(String[] args) {
            int[][] connections = {
                    {1,1,0,0,0,0},
                    {1,1,1,0,0,0},
                    {0,1,1,1,0,1},
                    {0,0,1,1,1,0},
                    {0,0,0,1,1,1},
                    {0,0,1,0,1,1}
            };
            int V = 6;
            System.out.println(articulationPoint(connections,V));
        }
    }
