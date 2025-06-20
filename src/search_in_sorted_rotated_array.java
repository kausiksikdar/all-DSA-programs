import java.util.Vector;

public class search_in_sorted_rotated_array {
    static int searchInSortedRotatedArray(int[] A, int target){
        //4 5 0 1 2 3
        int n=A.length;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(A[mid]==target) return mid;
            else if(A[mid]>=A[0]) {
                if(A[st]<target && A[mid]>target)
                    end=mid-1;
                else st=mid+1;
            }
            else {
                if(A[mid]<target && A[end]>target)
                    st=mid+1;
                else end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A={3,1};
        System.out.println(searchInSortedRotatedArray(A,1));
    }
}
