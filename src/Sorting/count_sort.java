package Sorting;

public class count_sort {
    /*
    * It is a non-comparison based way of sorting
    * Here we first we make a frequency array (named 'count') and store there the occurring of each element
    * Then according to that 'count' array we put elements in the original array

    * Making of frequency array(O(n)), Making of prefix sum array of frequency array(O(max)),
    Traversing the original array from end(O(n)), Copy the output array into the original array
    (O(n)) => total time = O(n+max) (Worst, Average case)
    * Best case = O(n) max = very, very small (But when Array have 4 elements but max=10^5) then
    it is very bad (We use it when max = very, very small)

    * SC = O(n+max) (not an In-place algo)
    */
    static void displayArr(int[] A){
        for(int i:A){
            System.out.print(i+" ");
        }
    }
    static int findMax(int[] A){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]>max) max=A[i];
        }
        return max;
    }
    //In this basicCountSort there is no specific order of stability
    static void basicCountSort(int[] A){ // 5 4 3 2 1 0
        int max=findMax(A); //max=5
        int[] count = new int[max+1];//Array of size 6 (5+1)
        for(int i=0;i<A.length;i++){ //Making of frequency array
            count[A[i]]++;
        }
        int k=0;  // Initialize a counter to traverse the original array
        for(int i=0;i< count.length;i++){ //Traverse the 'count' array
            for(int j=0;j<count[i];j++){ //Traverse the original array till the elements of count
                A[k++]=i;                //and put that in the original array
            }
        }
    }
    //For Stability, we use another approach
    static void countSort(int[] A){
        int max=findMax(A); //max=5
        int[] output=new int[A.length]; //Make a output array of size A.length
        int[] count = new int[max+1];//Array of size 6 (5+1)
        for(int i=0;i<A.length;i++){ //Making of frequency array
            count[A[i]]++;
        }
        for(int i=1;i<count.length;i++){ //Making of prefix sum array of frequency array
            count[i]+=count[i-1];
        }
        for(int i=A.length-1;i>=0;i--){ //Traversing the original array from end
            int idx=count[A[i]]-1; //Go to the index(i.e. A[i] as index) to the count array
            output[idx]=A[i];//Store the A[i] in the output array(It will always store the last occurring if duplicates present)
            count[A[i]]--; //Decrease the count[A[i]] by one
        }
        for(int i=0;i<A.length;i++){ //Copy the output array into the original array
            A[i]=output[i];
        }
    }
    public static void main(String[] args) {
        int[] A={5,4,4,3,2,1,0};
        System.out.println("Array before sorting =>");
        displayArr(A);
        System.out.println();
        countSort(A);
        System.out.println("Array after sorting =>");
        displayArr(A);
    }
}
