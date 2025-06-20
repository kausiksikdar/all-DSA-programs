package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class flood_fill {
    static int[] row = {0,0,1,-1};
    static int[] col = {1,-1,0,0};
    static boolean valid(int i, int j, int n, int m)
    {
        return i>=0 && i<n && j>=0 && j<m;
    }
    static int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        int n = image.length;
        int m = image[0].length;

        int prevColor = image[sr][sc];
        image[sr][sc] = color;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr,sc});

        while (!q.isEmpty())
        {
            int rowIdx = q.peek()[0];
            int colIdx = q.peek()[1];
            q.remove();

            for (int k=0;k<4;k++)
            {
                if (valid(rowIdx+row[k],colIdx+col[k],n,m) && image[rowIdx+row[k]][colIdx+col[k]]==prevColor)
                {
                    image[rowIdx+row[k]][colIdx+col[k]]=color;
                    q.add(new int[]{rowIdx+row[k],colIdx+col[k]});
                }
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int sr = 1, sc = 1, color = 2;
        int[][] ans = floodFill(image,sr,sc,color);
        for (int i=0;i<ans.length;i++)
        {
            for (int j=0;j<ans[0].length;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
