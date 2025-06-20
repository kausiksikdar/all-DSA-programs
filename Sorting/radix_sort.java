package Sorting;

public class radix_sort {
    /*
     * It is a non-comparison based way of sorting
     * Here we simply do sorting place by place (i.e. unit place => ten place => hundred place......)
     * First we find all place by place digit and implement count sort till it reaches the elements of all places

     * Making of frequency array(O(n)), Making of prefix sum array of frequency array(O(10)),
    Traversing the original array from end(O(n)), Copy the output array into the original array
    For count sort implemented in radix sort TC = O(n)
    For findmax(A) func. O(n) time needed
    If total digit=d, time needed=O(dn) (count sort implements 'd' times)

    * SC = O(n+10) => O(n)
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
    static void countSort(int[] A, int place){
        int[] output=new int[A.length]; //Make a output array of size A.length
        int[] count = new int[10];//Array of size 10(maximum digit possible in any place)
        for(int i=0;i<A.length;i++){ //Making of frequency array
            count[(A[i]/place)%10]++; //Increment the count array element according to its place
        }
        for(int i=1;i<count.length;i++){ //Making of prefix sum array of frequency array
            count[i]+=count[i-1];
        }
        for(int i=A.length-1;i>=0;i--){ //Traversing the original array from end
            int idx=count[(A[i]/place)%10]-1; //Go to the index(i.e. (A[i]/place)%10 as index) to the count array
            output[idx]=A[i];//Store the A[i](the entire value not any place digit as process may be done digit by digit but changes should be made by according to value) in the output array(It will always store the last occurring if duplicates present)
            count[(A[i]/place)%10]--; //Decrease the count[(A[i]/place)%10] by one
        }
        for(int i=0;i<A.length;i++){ //Copy the output array into the original array
            A[i]=output[i];
        }
    }
    static void radixSort(int[] A) {
        int max = findMax(A); //Find maximum element of array
        for (int place = 1; max / place > 0; place *= 10) { //iterate every place till it exists and call count sort
            countSort(A, place);
        }
    }
    public static void main(String[] args) {
            int[] A={5,4,4,3,2,1,0};
            System.out.println("Array before sorting =>");
            displayArr(A);
            System.out.println();
            radixSort(A);
            System.out.println("Array after sorting =>");
            displayArr(A);
        }
    }