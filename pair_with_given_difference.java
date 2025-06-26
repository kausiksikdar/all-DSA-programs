public class pair_with_given_difference {
    static boolean pairWithGivenDifference(int[] arr, int target){
        int n=arr.length;
        int st=0,end=1;
        while (st<n && end<n) {
            if(st==end) end++;
            if(arr[end]-arr[st]==target) return true;
            else if (arr[end]-arr[st]<target) end++;
            else st++;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,7,34,56,71};
        int target=51;
        System.out.println(pairWithGivenDifference(arr,target));
    }
}
