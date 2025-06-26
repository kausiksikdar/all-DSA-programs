public class transpose_a_matrix {
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
        for(int i=0;i<A.length;i++){
            for (int j=0;j<A.length;j++){
                System.out.print(A[i][j]+" ");;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        transpose(arr);
        /*
        1,2,3,4
        5,6,7,8
        9,10,11,12
        13,14,15,16
        */
    }
}
