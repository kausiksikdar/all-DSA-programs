package Sorting;

public class merge_sort {
    /*
     * We use Divide and Conquer method here to solve this problem

     * Divide the array into two equal parts
     * Sort the two sub-arrays using Recursion
     * Merge the two sorted sub-arrays to create an overall sub-array

     * For considering time complexity we clearly see that for merging the total time taken is
     O(length of the array) and every time n/2 recursive calls are made so overall (n/2^k)=1
     k=log(n) is the time of recursion so total time = recursive call time * merging time
                                                     =        log(n)       *    n
                                                     =            O(nlog(n))

     * Time complexity by method of substitution
     Let T(n) is the time to process total array
      T(n/2) is the time to process half array
      'n' is the time of merging
      * Total time taken = 2T(n/2)+n

      by substituting n=n/2 we get T(n/2)
      T(n/2) = (2^2)T(n/4)+2n
      * similarly, T(n/4) = (2^3)T(n/8)+3n
        T(n/2^k) = (2^k)T(n/2^k)+kn-------------------(*)

        * we know, time to process one array T(n) = 1 (constant time)
        If n/2^k = 1
            k = log(n)
        (*) =>  time = 2^(log(n))*1 + log(n)*n
                     =          n   +  nlog(n)
                     = O(nlog(n)) {ignoring 'n' term} (time of best,average as well as worst case)

       * space complexity = O(n) at a time we use maximum space of 'A.length' {not an In-place algo}

       * It is a stable algo as we use Lesser than equal to sign. in 'if' condition of 'merge'
       function, so if both elements are equal 1st element will be picked up from left array then
       the right one
       [2 3 4*] + [2* 4 5] = [2 2* 3 4* 4 5]
     */
    static void displayArray(int[] A){
        for(int i:A){
            System.out.print(i+" ");
        }
    }
    static void merge(int[] A, int l, int mid, int r){
        int n1=mid-l+1;
        int n2=r-mid;
        // Declaring the 'left' array which stores leftmost part of original array
        int[] left=new int[n1];
        // Declaring the 'right' array which stores rightmost part of original array
        int[] right=new int[n2];
        int i,j,k;
        // Here we cannot simply write left[i++]=A[i] as with every recursive call 'l' is
        // continuously changing
        for(i=0;i<n1;i++) left[i]=A[l+i]; //filling of left array
        for(j=0;j<n2;j++) right[j]=A[mid+1+j]; //filling of right array
        i=0; // left array traversal pointer
        j=0; // right array traversal pointer
        // we cannot write k=0 as 'k' is changing with every recursive call
        // 'k' represents the position in the Original array where the element should write
        k=l;
        //pouring correct elements from left and right to original array
        while(i<n1 && j<n2){
            if(left[i]<=right[j]) A[k++]=left[i++];
            else A[k++]=right[j++];
        }
        //If 'i' lags behind 'j' compensate it by below 'while' loop
        while(i<n1) A[k++]=left[i++];
        //If 'j' lags behind 'i' compensate it by below 'while' loop
        while(j<n2) A[k++]=right[j++];
    }
    static void mergeSort(int[] A, int l, int r){
        if(l>=r) return;
        // Finding the mid-position of the array
        int mid=(l+r)/2;
        // Calling merge sort on the left half part
        mergeSort(A,l,mid);
        // Calling merge sort on the right half part
        mergeSort(A,mid+1,r);
        // After calling the above both functions we assume that the original array will sort
        // in that two half part
        // Now it is the time to merge that two sorted part by 'merge' function
        merge(A,l,mid,r);
    }
    public static void main(String[] args) {
        int[] A={2,4,3,5,1,6,9,7,8,0};
        System.out.println("Array before sorting -> ");
        displayArray(A);
        mergeSort(A,0,A.length-1);
        System.out.println();
        System.out.println("Array after sorting -> ");
        displayArray(A);
    }
}