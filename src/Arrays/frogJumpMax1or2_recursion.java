package Arrays;

public class frogJumpMax1or2_recursion {
    /*brute force approach
    * time complexity = 2^n as each iteration calls the 'frogJump' method twice than previous*/
    static int frogJump(int[] A, int n, int idx){
        if(idx==n-1) return 0;
        int op1 = frogJump(A,n,idx+1)+Math.abs(A[idx+1]-A[idx]);
        if(idx==n-2) return op1;
        int op2 = frogJump(A,n,idx+2)+Math.abs(A[idx+2]-A[idx]);
        return Math.min(op1,op2);
    }

    public static void main(String[] args) {
        int[] A = {10,20,30,40,50};
        int n = A.length;
        System.out.println(frogJump(A,n,0));
    }
}
