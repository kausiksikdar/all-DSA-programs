package Arrays;

public class four_sum {
    static boolean fourSumOptimized(int[] arr, int target){ //TC=O(n^3)
        int n=arr.length;
        for(int i=0;i<n-2;i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int x = target - arr[i] - arr[j];
                int st = j + 1, end = n - 1;
                while (st <= end) {
                    if (arr[st] + arr[end] == x) return true;
                    else if (arr[st] + arr[end] < x) st++;
                    else end--;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,7,34,56,71};
        int target=16;
        System.out.println(fourSumOptimized(arr,target));
    }
}
