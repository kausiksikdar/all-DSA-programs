package Dynamic_Programming;

public class Longest_Palindromic_Subsequence {
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
    static int LongestPalindromicSubsequence(String s1, String s2)
    {
        return LCSSpaceOptimized(s1,s2);
    }
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("ABCCBADEF");
        String s1 = str1.toString();
        StringBuilder s2 = str1.reverse();
        System.out.println(LongestPalindromicSubsequence(s1,s2.toString()));
    }
}
