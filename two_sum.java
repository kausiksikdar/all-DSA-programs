public class two_sum {
    static boolean twoSumBetter(int[] A, int x){ //TC=O(nlogn)
        int n=A.length;
        for(int i=0;i<n;i++){
            int st=i,end=n-1;
            while (st<=end){
                int ans=x-A[i];
                int mid=st+(end-st)/2;
                if(A[mid]==ans){
                    return true;
                }
                else if (A[mid]<ans) {
                    st=mid+1;
                }
                else end=mid-1;
            }
        }
        return false;
    }
    static boolean twoSumOptimized(int[] A, int x){ //TC=O(n)
        int n=A.length;
        int st=0,end=n-1;
        while (st<=end){
            if(A[st]+A[end]==x) return true;
            else if(A[st]+A[end]<x) st++;
            else end--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,7,34,56,71};
        int target=12;
        System.out.println(twoSumOptimized(arr,target));
    }
}
