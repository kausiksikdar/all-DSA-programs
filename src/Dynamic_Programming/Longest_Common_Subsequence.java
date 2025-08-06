package Dynamic_Programming;

import java.util.Arrays;
/*
    LCS -> Longest Common Subsequence, is the longest common subsequence between two strings
    find the LCS between two Strings
*/
public class Longest_Common_Subsequence {
    static int LCSTopDown(String s1, String s2, int itr1, int itr2, int[][] dp)
    {
        //Base Case : Both the String is over
        if (itr1 < 0 || itr2 < 0)
            return 0;

        //return if it is already memoized
        if (dp[itr1][itr2] != -1)
            return dp[itr1][itr2];

        //If the particular character of both the string is same add 1 and go for next character
        if (s1.charAt(itr1) == s2.charAt(itr2))
            return dp[itr1][itr2]=1+LCSTopDown(s1,s2,itr1-1,itr2-1,dp);

        //else take maximum of (left one char of str1 and check, left one char of str2 and check)
        return dp[itr1][itr2]=Math.max(LCSTopDown(s1,s2,itr1-1,itr2,dp),LCSTopDown(s1,s2,itr1,itr2-1,dp));
    }
    static int LCSBottomUP(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i=1;i<=n;i++)
            for (int j=1;j<=m;j++)
            {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        return dp[n][m];
    }
    static int LCSSpaceOptimized(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0; // To store dp[j - 1] from previous row
            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; // store current dp[j] before updating for next iteration
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp; // update prev to old dp[j] for next iteration
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        String s1 = "ABCBA", s2 = "ABCBCBA";
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];

        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        System.out.println(LCSTopDown(s1,s2,n-1,m-1, dp));
        System.out.println(LCSBottomUP(s1,s2));
        System.out.println(LCSSpaceOptimized(s1,s2));
    }
}
