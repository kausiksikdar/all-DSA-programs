package Dynamic_Programming;
/*
    Same as house_robber_I, the only difference is, here the houses are in circular manner
    that is the last house is adjacent to first house like a circular way
*/
public class house_robber_II {
    static int maxAmountRobbedSpaceOptimized(int[] houses, int n, int stIndex)
    {
        int first = houses[stIndex];
        int second = houses[stIndex+1];
        for(int i=stIndex+2;i<n;i++)
        {
            int third = Math.max(houses[i] + first,  second);
            first = second;
            second = third;
        }
        return second;
    }
    public static void main(String[] args) {
        int[] houses = {1,12,13,1};
        int n = houses.length;
        //As the houses are in a circular manner, the 1st and last houses are adjacent so at a time we can't steal from 1st and last house simultaneously
        //So first we exclude the last house and include the first house and calculate and 2nd time we exclude the first house and include the last house and calculate
        System.out.println(Math.max(maxAmountRobbedSpaceOptimized(houses,n-1,0), maxAmountRobbedSpaceOptimized(houses,n,1)));
    }
}
