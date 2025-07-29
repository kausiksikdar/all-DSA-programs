package Dynamic_Programming;
/*
    Return the number of distinct ways to climb the nth stairs
    Conditions ->
    1. Each step, you can climb either 1 or 2 stairs
*/
public class climbing_stairs {
    static int climbingStairs(int n)
    {
        if(n==0)
            return 0;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    static int climbingStairsFormLast(int n)
    {
        if(n==0)
            return 0;

        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = 1;

        for(int i=n-2;i>=0;i--)
        {
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }
    static int climbingStairsSpaceOptimized(int n)
    {
        int first = 1, second = 1;
        while (n-->1)
        {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(climbingStairsSpaceOptimized(n));
    }
}
