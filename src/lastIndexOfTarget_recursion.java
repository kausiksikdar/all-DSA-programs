public class lastIndexOfTarget_recursion {
    static int lastIndexOfTarget(int[] A, int target, int idx){
        int n=A.length;
        int ans=-1;
        if(idx==n) return -1;
        if(A[idx]==target) ans=idx;
        int pre_ans=lastIndexOfTarget(A,target,idx+1);
        return Math.max(ans,pre_ans);
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,2};
        System.out.println(lastIndexOfTarget(A,2,0));
    }
}
