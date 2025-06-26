public class maximum_consecutive_ones {
    static int maximumConsecutiveOnes(int[] arr){
        int n=arr.length;
        int len=0,ans=0;
        for (int i=0;i<n;i++){
            if (arr[i]!=0) len++;
            else {
                ans=Math.max(ans,len);
                len=0;
            }
        }
        ans=Math.max(ans,len);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={0,1,0};
        System.out.println(maximumConsecutiveOnes(nums));
    }
}
