package Arrays;

public class check_if_sorted_and_rotated {
    static int findMaxIdx(int[] arr) {
        int n = arr.length;
        int maxValue = Integer.MIN_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static int findMinIdx(int[] arr) {
        int n = arr.length;
        int minValue = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    static boolean originalSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {

            }
            else {
                return false;
            }
        }
        return true;
    }

    static boolean checkRotatedAndSorted(int[] arr) {
        int n = arr.length;
        int first = 0, second = n - 1;
        while (first <= findMaxIdx(arr) && second >= findMinIdx(arr)) {
            if (arr[first] > arr[second]) {
                first++;
                second--;
            } else {
                return false;
            }
        }
        while (second >= findMinIdx(arr)) {
            if (arr[second] > arr[second - 1]) {
                second--;
            } else return false;
        }
        while (first <= findMaxIdx(arr)) {
            if (arr[first] > arr[first + 1]) {
                first++;
            } else return false;
        }
        return true;
    }

    static boolean sortedAndRotated(int[] arr) {
        if (originalSorted(arr)) return true;
        return checkRotatedAndSorted(arr);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        int[] arr1= {1, 2, 3};
        System.out.println(sortedAndRotated(arr));
        System.out.println(sortedAndRotated(arr1));
    }
}
