public class subsetSum {
    //by the help of Recursion(Principal of Inclusion and Exclusion) tree we apply this method
    static void subset_sum(int[] A, int n, int idx, int sum){
        if(idx>=n) {
            System.out.println(sum);
            return;
        }
        //Include the current idx in the sum
        subset_sum(A,n,idx+1,sum+A[idx]);
        //Exclude the current idx in the sum
        subset_sum(A,n,idx+1,sum);
    }

    public static void main(String[] args) {
        int[] A = {2,4,5};
        subset_sum(A,A.length,0,0);
    }
}
