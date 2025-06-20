package Arrays;

public class find_Kth_missing_element {
    static int findKthMissingElement(int[] A, int k){
        int n=A.length;
        int st=0,end=n-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(A[mid]-mid-1>=k) return mid+k;
            else st=mid+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] A={1,2,7,11,15};
        System.out.println(findKthMissingElement(A,9));
    }
}
