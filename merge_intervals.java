import java.util.ArrayList;
import java.util.Arrays;

public class merge_intervals {
    static void displayArray(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    static int[][] merge(int[][] arr) {
        int n = arr.length;
        ArrayList<int[]> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
        }
        for (int[] interval : arr) {
            if (temp.isEmpty() || temp.get(temp.size() - 1)[1] < interval[0]) {
                temp.add(interval);
            } else {
                temp.get(temp.size() - 1)[1] = Math.max(interval[1], temp.get(temp.size() - 1)[1]);
            }
        }
        return temp.toArray(new int[temp.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {
                {1,4},
                {0,4}
        };
        int[][] ans = merge(intervals);
        displayArray(ans);
    }
}
