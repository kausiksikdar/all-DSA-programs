public class number_of_occurence {
    static int findNumberOfOccurence(int[] arr, int target){
        int first=0,second=0;
        boolean flag=false;
        int n=arr.length;
        int st=0,end=n-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]==target){
                flag=true;
                first=mid;
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
                flag=true;
                second=mid;
                st = mid+1;
            }
            else if(arr[mid]<target) st = mid+1;
            else end = mid-1;
        }
        if(!flag) return 0;
        return second-first+1;
    }
    public static void main(String[] args) {
        int[] arr={3,4,4,4,4,4};
        int x=3;
        System.out.println(findNumberOfOccurence(arr, x));
    }
}
