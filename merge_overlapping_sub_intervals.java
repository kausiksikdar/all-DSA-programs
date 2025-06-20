import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class merge_overlapping_sub_intervals {
    static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] ans=merge(intervals);
        for (int[] i:ans){
            System.out.println(Arrays.toString(i));
        }
    }
}
