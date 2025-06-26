import java.util.Arrays;

public class three_sum_closest {
    static int threeSumClosest(int[] arr, int target){
        int n=arr.length;
        Arrays.sort(arr);
        int closestSum=Integer.MAX_VALUE;
        for (int i=0;i<n-2;i++){
            int st=i+1,end=n-1;
            while (st<end){
                int currSum=arr[i]+arr[st]+arr[end];
                if(Math.abs(currSum-target)<Math.abs(closestSum-target)){
                    closestSum=currSum;
                }
                if (currSum<target) {
                    st++;
                }
                else end--;
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        int[] arr={-4,1,2,-1};
        System.out.println(threeSumClosest(arr,1));
    }
}
