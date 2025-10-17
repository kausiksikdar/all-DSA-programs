package Stacks;

import java.util.Stack;

public class maximal_rectangle {
    static int rectangleFinder(int[] histogram) {
        int n = histogram.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int j = 0; j < n; j++) {
            while (!st.empty() && histogram[st.peek()] > histogram[j]) {
                int index = st.peek();
                st.pop();
                if (!st.empty()) {
                    ans = Math.max(ans, histogram[index] * (j - st.peek() - 1));
                } else {
                    ans = Math.max(ans, histogram[index] * j);
                }
            }
            st.push(j);
        }
        while (!st.empty()) {
            int index = st.peek();
            st.pop();
            if (!st.empty()) {
                ans = Math.max(ans, histogram[index] * (n - st.peek() - 1));
            } else {
                ans = Math.max(ans, histogram[index] * n);
            }
        }
        return ans;
    }
    static int maximalRectangle(int[][] rect){
        int row=rect.length;
        int col=rect[0].length;
        int ans=0;
        int[] tracker=new int[col];
        for (int j=0;j<row;j++){
            for (int k=0;k<col;k++){
                if (rect[j][k]==0){
                    tracker[k]=0;
                }
                else {
                    tracker[k]+=1;
                }
            }
            ans=Math.max(ans,rectangleFinder(tracker));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] rectangle={
                {1,0}
        };
        System.out.println(maximalRectangle(rectangle));
        
    }
}
