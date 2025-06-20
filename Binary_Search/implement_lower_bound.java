package Binary_Search;

import java.util.Arrays;

public class implement_lower_bound {
    static int implementLowerBound(int[] arr, int x){
        int n=arr.length;
        int ans=n;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]>=x){
                ans=mid;
                end=mid-1;
            }
            else {
                st=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,3};
        System.out.println(implementLowerBound(arr,4));
    }
}
