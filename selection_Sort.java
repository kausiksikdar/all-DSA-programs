public class selection_Sort {
    /*
    * Selects an element and puts it in correct order
    * we (n-1) number of passes under which we need another for loop((i+1)->(n-1))
    to find the minimum element of that array and swap with its correct position

    * Worst case TC=O(n^2)
    * Average case TC=O(n^2)
    * Best case TC=O(n^2)
    * SC=O(1) we don't take any extra space

    * It is not a stable algo as we use lesser than sign in 'if' condition so whenever
     it sees lesser element it swaps without maintaining relative order

     * It is an In_place algo as we don't use any extra Array

     * By Selection Sort we select one element and compare it with the other part of Array
     and place it put it in its correct order it can be used in 'lexicographical order' question
     */
    static void selectionSort(int[] A){
        int n= A.length;
        //'i' represents the current index
        for(int i=0;i<n-1;i++){
          //Find minimum element in unsorted part of Array
          int min_idx=i;
          for(int j=i+1;j<n;j++){
              if(A[j]<A[min_idx]){
                  min_idx=j;
              }
          }
          //swap current element with minimum element -> current idx 'i' have correct element
            //A[min_idx] with A[i]
            //Do swap if needed when i==min_idx means we are at middle of array So we don't need
            //to swap element with its own
            if(min_idx!=i){
                int temp=A[i];
                A[i]=A[min_idx];
                A[min_idx]=temp;
            }
        }
    }
    //We can implement by choosing maximum element and place it in correct position
    //rather choosing Smallest element and place it
    static void selectionSortAnother(int[] A){
        int n= A.length;
        //'i' represents the current index
        for(int i=n-1;i>0;i--){
            //Find maximum element in unsorted part of Array
            int max_idx=i;
            for(int j=i-1;j>=0;j--){
                if(A[j]>A[max_idx]){
                    max_idx=j;
                }
            }
            //swap current element with maximum element -> current idx 'i' have correct element
            //A[min_idx] with A[i]
            //Do swap if needed when i==max_idx means we are at middle of array So we don't need
            //to swap element with its own
            if(max_idx!=i){
                int temp=A[i];
                A[i]=A[max_idx];
                A[max_idx]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] A={3,4,2,0,5,6,7,9,1,8};
        selectionSortAnother(A);
        for(int i:A){
            System.out.print(i+" ");
        }
    }
}
