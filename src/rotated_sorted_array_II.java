public class rotated_sorted_array_II {
    static boolean searchInSortedRotatedArray(int[] A, int target){
        //4 5 0 0 1 2 3
        int n=A.length;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(A[mid]==target) return true;
            else if(A[mid]>=A[0]) {
                if(A[st]<=target && A[mid]>=target)
                    end=mid-1;
                else st=mid+1;
            }
            else {
                if(A[mid]<target && A[end]>=target)
                    st=mid+1;
                else end=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] A={4, 4, 5, 0, 0, 1, 2, 3, 3};
        System.out.println(searchInSortedRotatedArray(A,0));
    }
}
