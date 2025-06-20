public class rows_with_max_no_of_ones {
    static int lowerB(int[] arr){
        int m=arr.length;
        int low=0, high=m-1;
        int ans=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]==1){
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
    static int rowsWithMKaxNoOfOnes(int[][] arr){
        int n=arr.length,m=arr[0].length;
        int lb;
        int ones=0,ans=-1;
        for (int j=0;j<n;j++){ //O(n)
            lb=lowerB(arr[j]); //O(logm)
            if (lb==-1) continue;
            if ((m-lb)>ones){
                ones=m-lb;
                ans=j;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr={
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };
        System.out.println(rowsWithMKaxNoOfOnes(arr));
    }
}
