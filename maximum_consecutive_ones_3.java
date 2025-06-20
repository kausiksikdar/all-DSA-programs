public class maximum_consecutive_ones_3 {
    static int maximumConsecutiveOnes(int[] arr, int k){
        int n=arr.length;
        int left=0,ans=0,window=0;
        for(int right=0;right<n;right++){
            window+=arr[right];
            while (window+k<right-left+1){
                window-=arr[left];
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(maximumConsecutiveOnes(arr,k));
    }
}
