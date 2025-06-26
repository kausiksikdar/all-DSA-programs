package Sorting;

public class bubbleSort {
  /*
  we do certain no.(n-1) of passes in every pass we compare adjacent element
   and swap them if they are not in correct order

    in every iteration the largest no. in the remaining part of array to be processed
     and gets its correct position, after each iteration correct element must be at last
     the process continues as (j=0->n-i-1)

     Worst Case TC=O(n^2)
     Average Case TC=O(n^2)
     Best Case TC=O(n) (When we get already get sorted array)
     SC=O(1)

     Stable Algo = A algo which sorts the duplicates present in array
     without changing the relative order as they present in unsorted array

     (Bubble Sort is a Stable Algo as it does not have 'Equals to' sign at swapping so
     duplicates remains in same order)

     Un-Stable Algo = A algo which sorts the duplicates present in array may or
     may not changing the relative order as they present in unsorted array

     In-place Algo = We don't use extra space to sort this array, In the same array we sort
     this array, so Bubble sort is an In-place Algo

     It is very good algo to place elements from non-desired position to its required position
     */
    static void bubble_Sort(int[] A){
        int n = A.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                // Last "i" number of elements are already sorted position so no need to swap
                if(A[j]>A[j+1]){
                    // Swap
                    int temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                }
            }
        }
    }
    static void bubbleSortOptimized(int[] A){
        int n = A.length;
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<n-1-i;j++){
                // Last "i" number of elements are already sorted position so no need to swap
                if(A[j]>A[j+1]){
                    // Swap
                    int temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag) return;
        }
    }

    public static void main(String[] args) {
        int[] A={1,8,4,3,0,2,6};
        bubbleSortOptimized(A);
        for (int i:A) {
            System.out.print(i+" ");
        }
        System.out.println();
        int[] B={23,98,72,90,100,86,46};
         bubble_Sort(B);
        for (int i:B) {
            System.out.print(i+" ");
        }
    }
}
