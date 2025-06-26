public class spiral_form {
    static void printSpiralForm(int[][] A){
        int top=0;
        int right=A.length-1;
        int bottom=A.length-1;
        int left=0;
        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++){
                System.out.print(A[top][j]+" ");
            }
            top++;
            for(int i=top;i<=bottom;i++){
                System.out.print(A[i][right]+" ");
            }
            right--;
            //If it is a single row matrix So we put the below "if" condition
            if(top<=bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(A[bottom][j] + " ");
                }
                bottom--;
            }
            //If it is a single column matrix So we put the below "if" condition
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(A[i][left] + " ");
                }
                left++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSpiralForm(arr);
    }
}
