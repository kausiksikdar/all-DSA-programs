package Arrays;

public class find_first_and_last_pos_of_an_ele_in_an_array {
    static int[] findFirstAndLastPosition(int[] arr, int target){
        int[] ans = new int[2];
        int n = arr.length;
        int st = 0, end = n-1;
        //This loop is for checking the left part of the array for the first occurrence
       while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]==target){
                ans[0]=mid;
                end = mid-1;
            }
            else if(arr[mid]<target) st = mid+1;
            else end = mid-1;
        }
       st=0;
       end=n-1;
        //This loop is for checking the right part of the array for the last occurrence
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]==target){
                ans[1]=mid;
                st = mid+1;
            }
            else if(arr[mid]<target) st = mid+1;
            else end = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,3,4,5,5,5,6,6,7,8};
        int[] ans = findFirstAndLastPosition(arr,5);
        for (int i=0;i< ans.length;i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
