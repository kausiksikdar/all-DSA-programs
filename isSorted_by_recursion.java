public class isSorted_by_recursion {
    static boolean isSorted(int[] A, int idx){
        int n= A.length;
        if(idx==n-1) return true;
        boolean flag=true;
        if(A[idx]>A[idx+1]) flag=false;
        boolean pre_flags=isSorted(A,idx+1);
        return (flag & pre_flags);
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        System.out.println(isSorted(A,0));
    }
}
