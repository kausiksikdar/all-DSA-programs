import java.util.Arrays;

public class merge_sorted_array_codeStudio {
    static void swap(int[] nums1, int m, int[] nums2, int n) {
        int temp = nums1[m];
        nums1[m] = nums2[n];
        nums2[n] = temp;
    }
    // Compare the last element of nums1 with first element of nums2 and swap whenever we get mismatch i.e. from the mismatch part all are OK as both the array individually sorted
    static void mergeSortedArray2(int[] nums1, int m, int[] nums2, int n) {
        int last = m - 1;
        int first = 0;
        //After this while loop all smaller elements come to 1st array and remaining (comparatively larger) will go to other array
        while (first < n) {
            if (last >= 0 && nums1[last] > nums2[first]) {
                swap(nums1, last--, nums2, first++);
            }
            else break;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    //By Gap Method
    static void swapIfGreater(int[] nums1, int m, int[] nums2, int n) {
        if (nums1[m] > nums2[n]) {
            int temp = nums1[m];
            nums1[m] = nums2[n];
            nums2[n] = temp;
        }
    }

    static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        //Take the ceil value of len/2 named as gap
        int gap = (len / 2) + (len % 2);
        //After this while loop all smaller elements come to 1st array and remaining will go to other array
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(nums1, left, nums2, right - n);
                }
                else if (left >= n) {
                    swapIfGreater(nums1, left - n, nums2, right - n);
                }
                else {
                    swapIfGreater(nums1, left, nums2, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 5};
        int[] nums2 = {0, 4, 6, 7};
        mergeSortedArray2(nums1, nums1.length, nums2, nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.print("    ");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}
