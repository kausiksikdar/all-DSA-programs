public class smallest_divisor {
    static int max(int[] arr){
        int n= arr.length;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    static int generateSum(int[] arr, int mid){
        int n= arr.length;
        int sum=0;
        for (int i=0;i<n;i++){
           if (arr[i]%mid==0){
               sum+=arr[i]/mid;
           }
           else {
               sum+=arr[i]/mid+1;
           }
        }
        return sum;
    }
    static int smallestDivisor(int[] nums, int threshold){
        int low=1,high=max(nums);
        int ans=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            int sum=generateSum(nums,mid);
            if (sum>threshold){
                low=mid+1;
            }
            else {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,5,9};
        int threshold=6;
        System.out.println(smallestDivisor(arr,threshold));
    }
}
