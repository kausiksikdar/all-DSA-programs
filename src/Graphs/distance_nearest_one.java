package Graphs;

import java.util.*;

//Question -> Find the nearest 1 from each 0 of distance matrix in 4-directional way
/*
    What is the way of doing this problem -->
    Yes, We can surely say that BFS traversal will apply here
    but the twist is, here we think in reverse way that is, we observe the problem in angle of 1 instead of 0
    Find the nearest 0 for each 1 (as if 0->1, let dist = x then 1->0, dist = x also)
    Why -->
    In BFS traversal we go step by step, whenever we cross a particular step we don't have any info about previous step
    If we go for 0 to 1 then when we find 1, there is no way to update the steps to the 0's position(backward movement is not possible in BFS)
    So we go for 1 to 0 then we find 0, we update the steps in that 0's position in answer array(here move forward)
*/
public class distance_nearest_one {
    public static class Node{
        int row,col,steps;
        Node(int r, int c, int s)
        {
            row = r;
            col = c;
            steps = s;
        }
    }
    static int[] Row = {-1,1,0,0};
    static int[] Col = {0,0,-1,1};
    static boolean valid(int i, int j, int n, int m)
    {
        return i>=0 && j>=0 && i<n && j< m;
    }
    static void nearestOne(int[][] distance) {
        int n = distance.length;
        int m = distance[0].length;

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (distance[i][j] == 1) {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }

        while (!q.isEmpty())
        {
            Node top = q.poll();
            int row = top.row;
            int col = top.col;
            int steps = top.steps;

            ans[row][col] = steps;

            for(int k=0;k<4;k++)
            {
                int new_r = row+Row[k];
                int new_c = col+Col[k];

                if(valid(new_r,new_c,n,m) && !visited[new_r][new_c]) {
                    visited[new_r][new_c] = true;
                    q.offer(new Node(new_r, new_c, steps + 1));
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] distance = {
                {1,0,1},
                {1,1,0},
                {1,0,0}
        };
        nearestOne(distance);
    }
}
