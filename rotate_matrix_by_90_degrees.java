public class rotate_matrix_by_90_degrees {
    static void swap(int[][] A, int i, int j){
        int temp=A[i][j];
        A[i][j]=A[j][i];
        A[j][i]=temp;
    }
    static void transpose(int[][] A){
        for(int i=0;i<A.length-1;i++){
            for (int j=i+1;j<A.length;j++){
                swap(A,i,j);
            }
        }
    }
    static void swapNew(int[][] A, int i, int j, int k){
        int temp=A[i][j];
        A[i][j]=A[i][k];
        A[i][k]=temp;
    }
    static void reverse(int[][] A, int i){
        int j=0,k=A.length-1;
       while (j<k){
           swapNew(A,i,j,k);
           j++;
           k--;
      }
    }
    static void rotateMatrixBy90(int[][] arr){
        transpose(arr);
        for(int i=0;i<arr.length;i++){
            reverse(arr,i);
        }
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateMatrixBy90(arr);
        System.out.println();
        //To rotate it by 180 CW
        rotateMatrixBy90(arr);
        System.out.println();
        //To rotate it by 270 CW
        rotateMatrixBy90(arr);
        //To rotate it by 90 ACW => 270 CW
        //If we want to rotate 'k' times => you rotate it k%4 times, it brings the same result
         /*
        1,2,3,4
        5,6,7,8
        9,10,11,12
        13,14,15,16
        */
    }
}
