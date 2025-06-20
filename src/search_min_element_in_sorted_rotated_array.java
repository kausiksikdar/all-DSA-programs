public class search_min_element_in_sorted_rotated_array {
    static int searchMinElementInSortedRotatedArray(int[] A){
        int n=A.length;
        int ans=0;
        int st=0,end=n-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(A[mid]>=A[0]) st=mid+1;
            else {
                ans=mid;
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A={4,5,0,1,2,3};
        System.out.println(searchMinElementInSortedRotatedArray(A));
    }
}
