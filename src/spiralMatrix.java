import java.util.Scanner;
public class spiralMatrix {
    static void spiralMatrix(int[][] mat){
        int left = 0;
        int top = 0;
        int right = mat[0].length-1;
        int bottom = mat.length-1;
        int dir = 0;
        while (left<=right && top<=bottom){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    System.out.print(mat[top][i]+" ");
                }
                top++;
            }
            if(dir==1){
                for(int i=top;i<=bottom;i++){
                    System.out.print(mat[i][right]+" ");
                }
                right--;
            }
            if(dir==2){
                for(int i=right;i>=left;i--){
                    System.out.print(mat[bottom][i]+" ");
                }
                bottom--;
            }
            if(dir==3){
                for(int i=bottom;i>=top;i--){
                    System.out.print(mat[i][left]+" ");
                }
                left++;
            }
            dir = (dir+1)%4;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                    arr[i][j] = sc.nextInt();
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        spiralMatrix(arr);
    }
}
