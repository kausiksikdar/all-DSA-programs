package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class find_total_no_of_islands {
   static int[] row = {0,0,-1,1,1,-1,1,-1};
   static int[] col = {1,-1,0,0,1,-1,-1,1};

    static boolean valid(int i, int j, int n, int m)
    {
        return i>=0 && i<n && j>=0 && j<m;
    }
    static int totalNoOfIslands(int[][] lands)
    {
        int n = lands.length;
        int m = lands[0].length;

        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                if (lands[i][j]==1)
                {
                    lands[i][j]=0;
                    count++;
                    q.add(new int[]{i,j});
                    while (!q.isEmpty())
                    {
                        int rowIdx = q.peek()[0];
                        int colIdx = q.peek()[1];
                        q.remove();
                        for (int k=0;k<8;k++)
                        {
                            if (valid(rowIdx+row[k],colIdx+col[k],n,m) && lands[rowIdx+row[k]][colIdx+col[k]]==1)
                            {
                                lands[rowIdx+row[k]][colIdx+col[k]]=0;
                                q.add(new int[]{rowIdx+row[k],colIdx+col[k]});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] lands = {
                {1,1,1,0,0,0,1},
                {0,1,1,0,1,1,0},
                {1,0,0,0,0,0,0},
                {0,1,1,0,1,1,1},
                {1,1,0,0,0,1,0},
                {0,1,1,0,0,1,0}
        };
        System.out.println(totalNoOfIslands(lands));
    }
}
