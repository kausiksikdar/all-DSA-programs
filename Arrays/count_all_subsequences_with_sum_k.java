package Arrays;

import java.util.ArrayList;

public class count_all_subsequences_with_sum_k {
    static ArrayList<ArrayList<Integer>> print(int ind, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, int s, long k, int[] arr, int n){
        if (ind==n){
            if (s == k) {
                ans.add(ds);
            }
            return ans;
        }
        ArrayList<Integer> ds1=new ArrayList<>(ds);
        ds1.add(arr[ind]);
        s+=arr[ind];
        print(ind+1,ans,ds1,s,k,arr,n);
        s-=arr[ind];
        print(ind+1,ans,ds,s,k,arr,n);
        return ans;
    }
    static ArrayList<ArrayList<Integer>> printS(int[] arr, long k){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int ind=0;
        ArrayList<Integer>ds=new ArrayList<>();
        ans=print(ind,ans,ds,0,k,arr,arr.length);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,1};
        int k=2;
        System.out.println(printS(arr,k));
    }
}
