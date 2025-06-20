public class ways_to_sum_n {
    //By how many ways we can get the target while using a particular element with taking it once and without taking it.
    //TC=O((arr.length)^n)
    static int ways(int[] arr, int sum){
        if (sum==0) return 1;
        if (sum<0) return 0;
        int ans=0;
        for (int j=0;j< arr.length;j++){
            ans+=ways(arr,sum-arr[j]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,5,6,};
        int sum=7;
        int Ways=ways(arr,sum);
        System.out.println(Ways);
    }
}
