package Binary_Search;

import java.util.ArrayList;

public class median_of_row_wise_sorted_2D_array {
    static int countSmallerThanEqualToMid(int[] arr, int mid, int m) {
        int l = 0, h = m - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (arr[md] <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    static int median(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0, high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += countSmallerThanEqualToMid(arr[j], mid, m);
            }
            if (cnt <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}
        };
        System.out.println(median(arr));
    }
}
