package Graphs;

import java.util.Scanner;

public class Adjacency_Matrix_represent_of_graph {
    //un-directed un-weighted graph
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex,edges; //Declare the vertex and edges and take i/p
        vertex=sc.nextInt();
        edges=sc.nextInt();

        int[][] AdjMat = new int[vertex][vertex]; //create adjacency matrix

        int m,n; //initialize two variables to point edges

        for (int j=0;j<edges;j++){ //setting the edges between vertices
            m= sc.nextInt();
            n= sc.nextInt();
            AdjMat[m][n] = 1;
            AdjMat[n][m] = 1;
        }

         for (int j=0;j<vertex;j++){ //print the Adjacency matrix
             for (int k=0;k<vertex;k++){
                 System.out.print(AdjMat[j][k]+" ");
             }
             System.out.println();
         }

    }
}
