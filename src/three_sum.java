public class three_sum {
    static boolean threeSumOptimized(int[] arr, int target){ //TC=O(n^2)
        int n=arr.length;
        for(int i=0;i<n;i++){
            int x=target-arr[i];
            int st=i+1,end=n-1;
            while (st<=end){
                if(arr[st]+arr[end]==x) return true;
                else if (arr[st]+arr[end]<x) st++;
                else end--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,7,34,56,71};
        int target=15;
        System.out.println(threeSumOptimized(arr,target));
    }
}
