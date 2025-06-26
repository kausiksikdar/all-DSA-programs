package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class covid_spread {
    static int[] row = {0,0,1,-1};
    static int[] col = {1,-1,0,0};
   static boolean valid(int i, int j, int n, int m)
    {
        return i>=0 && i<n && j>=0 && j<m;
    }
    static int totalTimeToSpreadCovid(int[][] hospital)
    {
        int n = hospital.length;
        int m = hospital[0].length;

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0;i<n;i++)
            for (int j = 0; j < m; j++)
                if (hospital[i][j] == 2)
                    q.add(new int[]{i, j});

        while (!q.isEmpty()) {
                        time++;
                        int currPatient = q.size();
                        while (currPatient-- > 0) {
                            int rowIdx = q.peek()[0];
                            int colIdx = q.peek()[1];
                            q.remove();

                            for (int k = 0; k < 4; k++) {
                                if (valid(rowIdx + row[k], colIdx + col[k], n, m) && hospital[rowIdx + row[k]][colIdx + col[k]] == 1) {
                                    hospital[rowIdx + row[k]][colIdx + col[k]] = 2;
                                    q.add(new int[]{rowIdx + row[k], colIdx + col[k]});
                                }
                            }
                        }
                    }

        for (int[] ints : hospital) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1)
                    return -1;
            }
        }
        return time-1;
    }
    public static void main(String[] args) {
        int[][] hospital = {
                {0,1,2,1},
                {0,1,1,1},
                {0,1,0,0},
                {0,1,0,0}
        };
        System.out.println(totalTimeToSpreadCovid(hospital));
    }
}
