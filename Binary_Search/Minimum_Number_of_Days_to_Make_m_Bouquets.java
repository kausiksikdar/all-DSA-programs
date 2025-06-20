package Binary_Search;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    /*  You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.*/
    static int findMin(int[] A){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            min=Math.min(A[i],min);
        }
        return min;
    }
    static int findMax(int[] A){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            max=Math.max(A[i],max);
        }
        return max;
    }
    static boolean isPossible(int[] A, int mid, int m, int k){
        int flowers=0,bouquets=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<=mid) flowers++;
            else flowers=0;
            if(flowers==k){
                bouquets++;
                flowers=0;
            }
        }
        return bouquets>=m;
    }
    static int minDays(int[] A, int m, int k){
        int st=findMin(A),end=findMax(A),mid,ans=0,days=0,count=0,N=findMax(A)+1,counter=0;
       while (st<=end) {
           mid = st + (end - st) / 2;
         if(isPossible(A,mid,m,k)) {
             ans=mid;
             end=mid-1;
         }
         else st=mid+1;
       }
        return ans;
    }
    public static void main(String[] args) {
     int[] bloomDay = {1,10,3,10,2};
     int m = 3, k = 1;
        System.out.println(minDays(bloomDay,m,k));
    }
}
