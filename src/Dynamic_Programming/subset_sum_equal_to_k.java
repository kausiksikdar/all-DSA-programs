package Dynamic_Programming;

import java.util.Arrays;

public class subset_sum_equal_to_k {
    //Memoization DP code
    static boolean isTargetPossible(int[] arr, int target, int n, boolean[][] dp){
        if (target == 0)
            return true;
        if (n == 0)
            return false;

        if(dp[n][target])
            return dp[n][target];

        boolean notTake = isTargetPossible(arr,target,n-1,dp);

        boolean take = false;
        if (arr[n-1] <= target)
            take = isTargetPossible(arr,target-arr[n-1],n-1,dp);

        return dp[n][target] = take | notTake;

    }
    static boolean isTargetPossibleTabulation(int[] arr, int target){
        int n = arr.length;

        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0;i<=n;i++)
            dp[i][0] = true;

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=target;j++)
            {
                boolean notTake = dp[i-1][j];

                boolean take = false;
                if (arr[i-1] <= j)
                    take = dp[i-1][j-arr[i-1]];

                dp[i][j] = take | notTake;
            }
        }
        return  dp[n][target];
    }
    static boolean isTargetPossibleSpaceOptimized(int[] arr, int target){
        int n = arr.length;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for (int i=1;i<=n;i++)
        {
            for (int j=target;j>=arr[i-1];j--)
            {
                boolean notTake = dp[j];
                boolean take = dp[j-arr[i-1]];

                dp[j] = take | notTake;
            }
        }
        return  dp[target];
    }
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,4};
        int target = 70;
        boolean[][] dp = new boolean[arr.length+1][target+1];
        System.out.println(isTargetPossible(arr,target,arr.length,dp));
        System.out.println(isTargetPossibleTabulation(arr,target));
        System.out.println(isTargetPossibleSpaceOptimized(arr,target));
    }
}
