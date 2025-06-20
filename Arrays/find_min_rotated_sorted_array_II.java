package Arrays;

public class find_min_rotated_sorted_array_II {
    static int minValue(int[] A){
        int n=A.length;
        int st=0,end=n-1,mid=-1,ans=A[0];
        while (st<=end) {
            mid = st + (end - st) / 2;
            if (A[mid] >= A[0]) {
                st = mid + 1;
            } else {
                ans = A[mid];
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(minValue(nums));
    }
}
