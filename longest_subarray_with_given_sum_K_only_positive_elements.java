public class longest_subarray_with_given_sum_K_only_positive_elements {
    static int longestSubarray(int[] arr, int target) {
        int n = arr.length;
        int first = 0, second = 0, sum = arr[first], len = 0;
        while (second < n) {
            if (first <= second && sum > target) {
                sum -= arr[first];
                first++;
            }
            if (sum == target) {
                len = Math.max(second - first + 1, len);
            }
            second++;
            if (second < n) sum += arr[second];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3};
        int target = 2;
        System.out.println(longestSubarray(arr, target));
    }
}
