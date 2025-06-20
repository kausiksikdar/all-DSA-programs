import java.util.Arrays;

public class merge_sorted_array {
    //Compare the last elements of both arrays, according to the answer put it in the nums1 as it will store all the answer
    static void merge(int[] nums1, int m, int[] nums2, int n) {
       int p1=m-1; //Iterate over nums1 from m-1, as it is the last index where elements are present in nums1
       int p2=n-1; //Iterate over nums2
       int pMerge=n+m-1; //Iterate over nums1 from the last available position
       while (p2>=0){ //while all the elements of nums2 not covered
           if (p1>=0 && nums1[p1]>nums2[p2]){
               nums1[pMerge--]=nums1[p1--];
           }
           else {
               nums1[pMerge--]=nums2[p2--];
           }
       }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6,0};
        int[] nums2 = {3};
        merge(nums1, 5, nums2, nums2.length);
        for (int i=0;i< nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }
}
