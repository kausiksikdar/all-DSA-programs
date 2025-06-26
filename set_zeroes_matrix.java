public class set_zeroes_matrix {
    static void setZeroesMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int col_0 = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0) {
                        arr[0][j] = 0;
                    } else col_0 = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0) {
                    if (arr[0][j] == 0 || arr[i][0] == 0) {
                        arr[i][j] = 0;
                    }
                }
            }
        }
        if (arr[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }
        if (col_0 == 0) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr={
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroesMatrix(arr);
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
