package Arrays;

import java.util.*;

public class CountingFrequenciesOfArrayElements {

    public static void countFreq(int[] arr, int n) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        // Traverse through array elements and
        // count frequencies
        for (int i = 0; i < n; i++) {
            // Skip this element if already processed
            if (visited[i])
                continue;
            // Count frequency
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true; //checker that helps to stop repetitive processing of same element
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }
    static int findMax(int[] A){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]>max) max=A[i];
        }
        return max;
    }
    //Only beneficial when max element is not so large
    static void count(int[] A, int n){
        int max=findMax(A);
        int[] temp=new int[max+1];
        for(int i=0;i<n;i++){
            temp[A[i]]++;
        }
        for(int i=0;i< temp.length;i++){
            if(temp[i]>0){
                System.out.print(i+" "+temp[i]);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 20, 10, 10, 20, 5, 20, 30};
        int n = arr.length;
        countFreq(arr, n);
    }
}

