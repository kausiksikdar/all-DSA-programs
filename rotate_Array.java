import java.util.Scanner;

public class rotate_Array {
    static void rotateArray(int[][] A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                if(j>i || j==A.length-1 || i== A.length-1){
                    if(j==A.length-1 || i== A.length-1){
                        int temp=A[A.length-1][1];
                        A[A.length-1][1]=A[1][A.length-1];
                        A[1][A.length-1]=temp;
                    }
                    else {
                        int temp=A[i][j];
                        A[i][j]=A[i+1][j-1];
                        A[i+1][j-1]=temp;
                    }
                }
            }
        }
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] nums = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        rotateArray(nums);
    }
}
