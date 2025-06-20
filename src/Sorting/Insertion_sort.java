package Sorting;

public class Insertion_sort {
    /*
    * Take one element, iterate over the array and find its correct position in sorted array and
    place it in its correct order in sorted array

    * Best case TC=O(n) (When we get already sorted array)
    * Average case TC=O(n^2)
    * Worst case TC=O(n^2)
    * SC=O(1)

    * It is a stable algo as we don't put any equals to sign. while swapping

    * It is an In-place algo as WE DON'T USE ANY EXTRA SPACE

    * Insertion Sort is mainly used when we take an element and put one element from
    a place(unsorted part) to another place(sorted part)
    */
    static void insertionSort(int[] A){
        int n= A.length;
        //This 'for' loop starts from '1' as we consider that
        // 1st of element is always a part of sorted array
        //'i' represents the current index over which we stand
        for(int i=1;i<n;i++){
            //we need a 'j' variable so that we iterate over the unsorted part(i -> n-1) and put 'ith'
            //element at its correct position by comparing it with the elements of
            // sorted part(0 -> i-1) of the array
         int j=i;
         //we're continuously swapping the 'ith' element till the correct index found
            //we check it till j>0 and continuously swapping
         while (j>0&&A[j]<A[j-1]){
             //swap
             int temp=A[j];
             A[j]=A[j-1];
             A[j-1]=temp;
             j--;
         }
        }
    }

    public static void main(String[] args) {
        int[] A={2,4,5,0,6,1,3,9};
        insertionSort(A);
        for(int i:A){
            System.out.print(i+" ");
        }
    }
}
