public class productOfArrayExceptSelf {
    static int[] productExceptSelf(int[] A){
        int[] ans = new int[A.length];
        int[] prefix = new int[A.length];
        System.arraycopy(A, 0, prefix, 0, prefix.length);
        for(int i=1;i< prefix.length;i++){
            prefix[i]*=prefix[i-1];
        }
        int[] suffix = new int[A.length];
        System.arraycopy(A, 0, suffix, 0, suffix.length);
        for(int i= suffix.length-2;i>=0;i--){
            suffix[i]*=suffix[i+1];
        }
        ans[0]=suffix[1];
        for(int i=1;i<ans.length-1;i++){
            ans[i]=suffix[i+1]*prefix[i-1];
        }
        ans[ans.length-1]=prefix[prefix.length-2];
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2,4,5,6};
       int[] a = productExceptSelf(A);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
}
