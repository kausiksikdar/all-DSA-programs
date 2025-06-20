package Binary_Search;

public class find_correct_index {
    static int findCorrectIndex(int[] arr, int target){
        int st=0, end=arr.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;
         if(arr[mid]==target) return mid;
         else if(arr[mid]<target) st=mid+1;
         else end=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] ques = {1,21,34,52,63,74};
        System.out.println(findCorrectIndex(ques,34));
    }
}
