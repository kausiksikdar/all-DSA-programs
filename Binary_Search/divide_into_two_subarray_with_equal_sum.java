package Binary_Search;

public class divide_into_two_subarray_with_equal_sum {
    static boolean isPossible(int[] arr){
        int n=arr.length,totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
        }
        int prefix=0;
        for(int i=0;i<n;i++){
            prefix+=arr[i];
            if(prefix==totalSum-prefix) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={2,3,-1,0,2,2};
        System.out.println(isPossible(arr));
    }
}
