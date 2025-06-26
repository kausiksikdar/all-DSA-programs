package Binary_Search;

import java.util.ArrayList;

public class median_of_two_sorted_array {
    static double medianBrute(int[] A, int[] B){
        int n=A.length;
        int m= B.length;
        ArrayList<Integer> lst=new ArrayList<>(); //Creating an extra arraylist So the space complexity is O(m+n)
        int i=0,j=0;
        //Traversing all the elements of the arraylist So the time complexity will be O(m+n)
        while (i<n && j<m){
            if(A[i]<B[j]){
                lst.add(A[i]);
                i++;
            }
            else {
                lst.add(B[j]);
                j++;
            }
        }
        while (i<n){
            lst.add(A[i]);
            i++;
        }
        while (j<m){
            lst.add(B[j]);
            j++;
        }
        if((n+m)%2==1) return (double)(lst.get((m+n)/2));
        return  (double)(lst.get((m+n)/2)+lst.get(((m+n)/2)-1))/2.0;
    }
    //First try to optimise the space
    /*
    By the Definition of median it lies exactly the mid of merged array
    So firstly we find the correct indices where the median should lie
    Then there is a counter variable which tracks that we should not surpass the reqd. indices
    */
    // NO extra space is used as we are iterating the original arrays but time will remain the same
    static double medianBetter(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int x = n + m;
        int ind_1 = x / 2; //Correct index_1
        int ind_2 = x / 2 - 1; //Correct index_2
        int ind_1_el = -1, ind_2_el = -1; //Variable to store the reqd. elements
        int cnt = 0; //Tracker that tracks that while iterating we should not surpass the reqd. indices
        int i = 0, j = 0;
            while (i < n && j < m) {
                if (A[i] < B[j]) {
                    if (cnt == ind_1) ind_1_el = A[i];
                    if (cnt == ind_2) ind_2_el = A[i];
                    i++;
                    cnt++;
                } else {
                    if (cnt == ind_1) ind_1_el = B[j];
                    if (cnt == ind_2) ind_2_el = B[j];
                    j++;
                    cnt++;
                }
            }
            while (i < n) {
                if (cnt == ind_1) ind_1_el = A[i];
                if (cnt == ind_2) ind_2_el = A[i];
                i++;
                cnt++;
            }
            while (j < m) {
                if (cnt == ind_1) ind_1_el = B[j];
                if (cnt == ind_2) ind_2_el = B[j];
                j++;
                cnt++;
            }
        if (x % 2 == 0) return ((double) (ind_1_el + ind_2_el) / 2.0);
        else return ind_1_el;
    }
    //Now it is the time to optimise the time complexity
    /*
    * Here we take a time = O(Math.min(log m,log n)) as we apply binary search on smaller array
    * Overall Space = O(1)
    */
    static double medianOptimized(int[] A, int[] B){
        int n=A.length;
        int m=B.length;
        int left=(n+m+1)/2;
        if(n>m) return medianOptimized(B,A);
        int low=0,high=n;
        while (low<=high){
            int mid_1=low+high >> 1;
            int mid_2=left-mid_1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid_1<n) r1=A[mid_1];
            if(mid_2<m) r2=B[mid_2];
            if(mid_1-1>=0) l1=A[mid_1-1];
            if(mid_2-1>=0) l2=B[mid_2-1];
            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0) return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else return Math.max(l1,l2);
            }
            else if (l1>r2){
                high=mid_1-1;
            }
            else low=mid_1+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(medianOptimized(nums1,nums2));
    }
}
