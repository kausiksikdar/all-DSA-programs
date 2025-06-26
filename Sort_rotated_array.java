public class Sort_rotated_array {
    /*
    * An array is given to us which is almost sorted except two elements which is swapped(see input sets)
    * Write an algo to correct this

    * We first find out that two conflicts then first update 'x' only once and update 'y' two times
    (See input sets and observe the algo properly)
    */
    static void displayArr(int[] A){
        for(int i:A){
            System.out.print(i+" ");
        }
    }
    static void swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    static void sortArray(int[] A){
        int n=A.length;
        if(n<=1) return;
        int x=-1,y=-1;
        for(int i=1;i<n;i++){
            if(A[i-1]>A[i]){
                if(x==-1){
                    x=i-1;
                }
                y=i;
            }
        }
        swap(A,x,y);
    }
    public static void main(String[] args) {
        int[] A={6,3,4,5,2};
        int[] B={2,1};
        sortArray(A);
        displayArr(A);
    }
}
