package Binary_Search;

public final class basic_binary_search {
    //It has 'nlogn' time complexity but the array must be sorted in nature
    static int binarySearch(int[] arr){
        int n = arr.length;
        int st = 0, end= n-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]==790) return 1;
            else if(arr[mid]<790) st=mid+1;
            else end=mid-1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,65,78,90,790}; //Binary search is only applicable when *Sorted array is given
        System.out.println(binarySearch(arr));
    }
}
