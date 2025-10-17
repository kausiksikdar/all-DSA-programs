package Dynamic_Programming;
import java.util.*;
/*
Ninja has a grid of size R x C, where each cell contains some chocolates. He has two friends: Alice and Bob, and wants to collect as many chocolates as possible using their help.



Alice starts at the top-left cell (0, 0)
Bob starts at the top-right cell (0, C - 1)
Both can only move to the next row, and from position (i, j), they can move to:
(i + 1, j)
(i + 1, j - 1)
(i + 1, j + 1)


Both must remain within the grid bounds.
Each collects all chocolates in their current cell.
If both land on the same cell, the chocolates are only counted once.


Return the maximum number of chocolates Ninja can collect using his two friends.



Input: grid = [[2, 3, 1, 2],[3, 4, 2, 2],[5, 6, 3, 5]]

Output: 21

Explanation:

Alice: (0,0) → (1,1) → (2,1) → chocolates = 2 + 4 + 6 = 12
Bob:  (0,3) → (1,3) → (2,3) → chocolates = 2 + 2 + 5 = 9
Total = 12 + 9 = 21
*/
public class Ninja_and_his_Friends {
    // Memoization (Top-Down Approach)
    static int maxCollection(int[][] grid, int row, int aliceCol, int bobCol, int m, int n, int[][][] dp)
    {
        if(aliceCol < 0 || bobCol < 0 || bobCol >= m || aliceCol >= m) // Invalid Column case
            return -100000000;

        if(row == n-1) // If we reached the destination
        {
            if (aliceCol == bobCol)
                return grid[row][aliceCol]; // Both are in same cell
            else
                return grid[row][aliceCol]+grid[row][bobCol]; // Both are on different cell
        }

        if (dp[row][aliceCol][bobCol] != -1)
            return dp[row][aliceCol][bobCol];

        int maxi = Integer.MIN_VALUE;
        for (int j1 = -1; j1 <= 1; j1++)
        {
            int newAliceCol = aliceCol+j1;
            for(int j2 = -1; j2 <= 1; j2++)
            {
                int newBobCol = bobCol+j2;

                int nextPaths = maxCollection(grid, row + 1, newAliceCol, newBobCol, m, n, dp);
                if (aliceCol == bobCol) {
                    // Both are standing in the same cell
                    if (nextPaths != -100000000)
                        maxi = Math.max(maxi, grid[row][aliceCol] + nextPaths);
                }
                else {
                    // Both are on different cell
                    if (nextPaths != -100000000)
                        maxi = Math.max(maxi, grid[row][aliceCol] + grid[row][bobCol] + nextPaths);
                }
            }
        }

        return dp[row][aliceCol][bobCol] = maxi;
    }
    static int maxChocolate(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
//        int[][][] dp = new int[n][m+1][m+1];

//        for (int i=0;i<n;i++)
//            for (int j=0;j<=m;j++)
//                Arrays.fill(dp[i][j], -1);
//
//        return maxCollection(grid,0,0,m-1,m,n,dp);

        // Tabulation(Bottom -Up) Approach

//        for (int j1=0;j1<m;j1++)
//        {
//            for (int j2=0;j2<m;j2++)
//            {
//                if (j1 != j2)
//                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
//                else
//                    dp[n-1][j1][j2] = grid[n-1][j1];
//            }
//        }
//
//        for (int i=n-2;i>=0;i--)
//        {
//            for (int j1=0;j1<m;j1++)
//            {
//                for (int j2=0;j2<m;j2++)
//                {
//                    int maxi = Integer.MIN_VALUE;
//                    for (int d1=-1;d1<=1;d1++)
//                    {
//                        int newJ1 = j1+d1;
//
//                        if (!valid(newJ1,m))
//                            continue;
//
//                        for (int d2=-1;d2<=1;d2++)
//                        {
//                            int newJ2 = j2+d2;
//
//                            if (!valid(newJ2,m))
//                                continue;
//
//                            int nextPaths = dp[i+1][newJ1][newJ2];
//
//                            if (j1 == j2)
//                                maxi = Math.max(maxi, grid[i][j1]+nextPaths);
//                            else
//                                maxi = Math.max(maxi, grid[i][j1]+grid[i][j2]+nextPaths);
//                        }
//                    }
//                    dp[i][j1][j2] = maxi;
//                }
//            }
//        }
//        return dp[0][0][m-1];

        // Space Optimization of Bottom Up

        int[][] dp = new int[m][m];
        int[][] prev = new int[m][m];

        for (int j1=0;j1<m;j1++)
        {
            for (int j2=0;j2<m;j2++)
            {
                if (j1 == j2)
                    prev[j1][j2] = grid[n-1][j1];
                else
                    prev[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for (int i=n-2;i>=0;i--)
        {
            dp = new int[m][m];
            for (int j1=0;j1<m;j1++)
            {
                for (int j2=0;j2<m;j2++)
                {
                    int maxi = Integer.MIN_VALUE;
                    for (int d1=-1;d1<=1;d1++)
                    {
                        int newJ1 = j1+d1;

                        if (!valid(newJ1,m))
                            continue;

                        for (int d2=-1;d2<=1;d2++)
                        {
                            int newJ2 = j2+d2;

                            if (!valid(newJ2,m))
                                continue;

                            int nextPaths = prev[newJ1][newJ2];

                            if (j1 == j2)
                                maxi = Math.max(maxi, grid[i][j1]+nextPaths);
                            else
                                maxi = Math.max(maxi, grid[i][j1]+grid[i][j2]+nextPaths);
                        }
                    }
                    dp[j1][j2] = maxi;
                }
            }
            prev = dp;
        }
        return dp[0][m-1];
    }

    static boolean valid(int j, int m)
    {
        return j>=0 && j<m;
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 2},{3, 4}};

        System.out.println(maxChocolate(grid));
    }
}
