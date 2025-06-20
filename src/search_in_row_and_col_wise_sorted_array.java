public class search_in_row_and_col_wise_sorted_array {
    static boolean search(int[][] A, int target){
        int n=A.length;
        int m=A[0].length;
        int i=n-1,j=0;
        while (i>=0 && j<m){
            if(A[i][j]==target){
                return true;
            }
            else if (A[i][j]<target) {
                j++;
            }
            else i--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr={
                {4,8,15,25,60},
                {18,22,26,42,80},
                {36,40,45,68,104},
                {48,50,72,83,130},
                {70,99,114,128,170}
        };
        int target=72;
        System.out.println(search(arr,target));
    }
}
