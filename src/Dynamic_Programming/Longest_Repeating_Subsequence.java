package Dynamic_Programming;
/*
    Given a String, Print the longest Common Subsequence in the string that appears twice in the string
*/
public class Longest_Repeating_Subsequence {
    static String LCS(String s)
    {
        StringBuilder LCS = new StringBuilder();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for (int i=1;i<n;i++)
        {
            for (int j=1;j<n; j++)
            {
                if (i == j)
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                else if(s.charAt(i-1) == s.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        System.out.println(dp[n][n]);
        return LCS.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "XXXXXXXXXAAAA";
        System.out.println(LCS(s));
    }
}
