import java.util.ArrayList;
import java.util.List;

public class print_subsequences_of_array {
    public static void cal(int n, ArrayList<Integer> curr, int[]nums, List<List<Integer>> L){
        if(n==nums.length){
            L.add(curr);
            return;
        }
        // Yes
        ArrayList<Integer> a2=new ArrayList<>(curr);
        a2.add(nums[n]);
        cal(n+1,a2,nums,L);
        // No
        cal(n+1,curr,nums,L);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> L=new ArrayList<>();
        cal(0,new ArrayList<>(),nums,L);
        return L;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(subsets(arr));
    }
}
