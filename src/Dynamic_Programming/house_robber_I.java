package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

/*
    There is a robber, wanted to rob the houses and steal maximum amount of money but
    the condition is he can't rob adjacent houses, Given the house array having the money at ith position
    of ith house
*/
public class house_robber_I {
    static int maxAmountRobbedTopDown(int[] houses, int[] dp, int index)
    {
        if(index >= houses.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        return dp[index] = Math.max(houses[index]+maxAmountRobbedTopDown(houses,dp,index+2),maxAmountRobbedTopDown(houses,dp,index+1));
    }
    static int maxAmountRobbedBottomUp(int[] houses, int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = houses[0];
        for(int i=2;i<=n;i++)
        {
            dp[i] = Math.max(houses[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[n];
    }
    static int maxAmountRobbedSpaceOptimized(int[] houses, int n)
    {
        int first = 0;
        int second = houses[0];
        for(int i=2;i<=n;i++)
        {
           int third = Math.max(houses[i-1] + first,  second);
           first = second;
           second = third;
        }
        return second;
    }
    static int maxAmountRobbedSpaceOptimized2(int[] houses, int n)
    {
        int first = houses[0];
        int second = houses[1];
        for(int i=2;i<n;i++)
        {
            int third = Math.max(houses[i] + first,  second);
            first = second;
            second = third;
        }
        return second;
    }
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};
        int n = houses.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(maxAmountRobbedTopDown(houses,dp,0));
        System.out.println(maxAmountRobbedBottomUp(houses,n));
        System.out.println(maxAmountRobbedSpaceOptimized(houses,n));
        System.out.println(maxAmountRobbedSpaceOptimized2(houses,n));
    }
}
