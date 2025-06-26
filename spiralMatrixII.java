import java.util.ArrayList;
import java.util.Scanner;

public class spiralMatrixII {
    static ArrayList spiralMatrixII(int[][] mat,ArrayList<Integer> ans) {
        int value = 0;
        int left = 0;
        int top = 0;
        int right = mat[0].length - 1;
        int bottom = mat.length - 1;
        int dir = 0;
        while (left <= right && top <= bottom) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    value++;
                    ans.add(value);
                }
                top++;
            }
            if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    value++;
                    ans.add(value);
                }
                right--;
            }
            if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    value++;
                    ans.add(value);
                }
                bottom--;
            }
            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    value++;
                    ans.add(value);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
          return ans;
    }

    public static void main(String[] args) {

            int[][] arr = new int[5][5];


            ArrayList<Integer> arra = new ArrayList<>();
        System.out.println(spiralMatrixII(arr,arra));
        }
}


