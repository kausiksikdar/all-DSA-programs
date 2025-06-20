import java.util.*;
public class spiralMatrix3 {
    /*
    //INTUTION//
    If we see carefully here only 4 directions are used
    * 1. for right d=0
    * 2. for down d=1
    * 3. for left d=2
    * 4. for top d=3
    * in only left or right direction the length of col is inc. or dec.
    * and for top or down dir only one time row is inc. or dec. but col remain same
    //WHAT & HOW variables are used//
    * So here we keep a "d" variable which indicates direction
    * when d==0||d==2 it means left or right
    * means we need to inc. or dec. col
    * so we take a "len" variable to keep track up to where to print
    * so 1st we inc. len by 1 and then print the row and col indices by the help of direction array
    * and for row update d==1||d==3 it means top or down
    * for that by the help of direction array we inc. or dec. row by 1 and col remains same
    */
    static int[][] spiralMatrix(int R,int C, int r0, int c0){
        int[][] dirt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // east, south, west, north
        List<int[]> res = new ArrayList<>();
        int len = 0, d = 0; // move <len> steps in the <d> direction
        res.add(new int[]{r0, c0});
        while (res.size() < R * C) {
            if (d == 0 || d == 2) len++; // when move east or west, the length of path need plus 1
            for (int i = 0; i < len; i++) {
                r0 += dirt[d][0];
                c0 += dirt[d][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) // check valid
                    res.add(new int[]{r0, c0});
            }
            d = (d + 1) % 4; // turn to next direction
        }
        return res.toArray(new int[R * C][2]);
    }

    public static void main(String[] args) {
        int[][] ans = spiralMatrix(5,6,1,4);
        for (int[] an : ans) {
            for (int j = 0; j < 2; j++) {
                System.out.print(an[j] + " ");
            }
            System.out.println();
        }
    }
}
