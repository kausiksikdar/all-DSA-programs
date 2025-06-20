package Arrays;

public class kadanesAlgo_findTheLargestSumSubArray {
    static int kadanesAlgo(int[] A){
        int n= A.length;
        if(n==1) return A[n-1];
        int max=Integer.MIN_VALUE, prefix=0; //Here we take a 'prefix' variable which does not change the values of original array
        for(int i=0;i<n;i++){
           prefix+=A[i]; //We iterate and update prefix
           max = Math.max(prefix,max); //Update 'max'
           if(prefix<0) prefix=0; //If prefix<0, make it '0'
        }
        return max;
    }
    public static void main(String[] args) {
        int[] A={2,-1};
        int k = kadanesAlgo(A);
        System.out.println(k);
    }
}
