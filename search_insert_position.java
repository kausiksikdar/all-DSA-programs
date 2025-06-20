public class search_insert_position {
    static int searchInsertPosition(int[] arr, int target){
        int ans=0;
        int n= arr.length;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]<target){
                ans=mid+1;
                st=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,3,4,6};
        int target=2;
        System.out.println(searchInsertPosition(arr, target));
    }
}
