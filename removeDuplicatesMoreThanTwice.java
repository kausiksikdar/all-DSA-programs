public class removeDuplicatesMoreThanTwice {
    static int removeDuplicates(int[] A){
        if (A.length<=2) return A.length;
        int count=-1;
        int j=0;
        if(A[0]!=A[2]) {
            A[j]=A[0];
            j++;
        }
        for(int i=0;i<A.length-1;i++){
            if(A[i]==A[i+1]){
                 count++;
            }
            else count=0;
            if(count<2){
                A[j]=A[i+1];
                j++;
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int k = removeDuplicates(nums);
        System.out.println(k);
    }
}
