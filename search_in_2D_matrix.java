public class search_in_2D_matrix {
    static boolean search(int[][] matrix, int target){
        int left, right, mid;
        for (int i = 0; i < matrix.length; i++) {
            left = 0;
            right = matrix[i].length - 1;

            if (matrix[i][right] >= target) {

                while (left <= right) {
                    mid = left + (right - left) / 2;

                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] arr={
                     {1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}
              };
        int[][] matrix={
                {1,4},
                {2,5},
        };
        int x=2;
        System.out.println(search(matrix,x));
    }
}
