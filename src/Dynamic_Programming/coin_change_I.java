package Dynamic_Programming;

import java.util.Arrays;

/*
    Coin Change I -> You have infinite supply of coins of denomination mentioned coins array
    You have to make the amount given with the coins, Calculate the total number of ways to make the amount
*/
public class coin_change_I {
    static int waysToMakeAmountTopDown(int[] coins, int amount, int index, int currAmount, int n, int[][] dp)
    {
        if(currAmount == amount)
            return 1;
        if(currAmount > amount)
            return 0;
        if (index == n)
            return 0;

        if (dp[index][currAmount] != -1)
            return dp[index][currAmount];

        return dp[index][currAmount] = waysToMakeAmountTopDown(coins,amount,index,currAmount+coins[index],n,dp) + waysToMakeAmountTopDown(coins,amount,index+1,currAmount,n,dp);
    }
    static int waysToMakeAmountBottomUp(int[] coins, int amount)
    {
        if(amount < 0) {
            System.out.println("Please Enter a valid amount");
            return -1;
        }

        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int j=0;j<=amount;j++)
            dp[0][j] = 0;

        for(int i=0;i<=n;i++)
            dp[i][0] = 1;

        for(int i=1;i<=n;i++)
            for(int j=1;j<=amount;j++)
            {
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }

        return dp[n][amount];
    }
    static int waysToMakeAmountSpaceOptimized(int[] coins, int amount)
    {
        if(amount < 0) {
            System.out.println("Please Enter a valid amount");
            return -1;
        }

        int n = coins.length;
        int[] dp = new int[amount+1];

        dp[0] = 1;

        for(int i=1;i<=n;i++)
            for(int j=1;j<=amount;j++)
            {
                if(j >= coins[i-1])
                    dp[j] += dp[j-coins[i-1]];
            }

        return dp[amount];
    }
    static int waysToMakeAmount(int[] coins, int amount)
    {
        if(amount < 0) {
            System.out.println("Please Enter a valid amount");
            return -1;
        }

        int n = coins.length;
        int[][] dp = new int[n][amount];

        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        return waysToMakeAmountTopDown(coins,amount,0,0,n,dp);
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(waysToMakeAmountBottomUp(coins,amount));
        System.out.println(waysToMakeAmount(coins,amount));
        System.out.println(waysToMakeAmountSpaceOptimized(coins,amount));
    }
}
