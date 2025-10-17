package Dynamic_Programming;
import java.util.*;
public class maximal_rectangle {
    private static int maxi = 0;
    private static int[][] dp;

    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        solve(matrix, 0, 0);

        return maxi * maxi;
    }

    private static int solve(char[][] matrix, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(matrix, i, j + 1);
        int diagonal = solve(matrix, i + 1, j + 1);
        int down = solve(matrix, i + 1, j);

        if (matrix[i][j] == '1') {
            dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
            maxi = Math.max(maxi, dp[i][j]);
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j];
    }
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}
