import java.util.Scanner;

public class print_sum_of_diagonal_elements {
    static int[] sumOfAllElements(int[][] arr) {
        int[] ans = new int[2];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
        }
        ans[0] = sum1;
        int i = 0, j = arr[0].length-1;
        while (j >= 0) {
            sum2 += arr[i][j];
            i++;
            j--;
        }
        ans[1]=sum2;
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr=new int[4][4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<2;i++){
            System.out.print(sumOfAllElements(arr)[i]+" ");
        }
    }
}
