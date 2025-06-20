import java.util.Stack;

public class largest_rectangle_in_histogram {
    static int largestRectangleHistogram(int[] histogram) { //Optimized sol. with 3 passes
        int n = histogram.length;
        int ans = 0;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int j = 0; j < n; j++) {
            while (!st.empty() && histogram[st.peek()] > histogram[j]) {
                right[st.peek()] = j;
                st.pop();
            }
            st.push(j);
        }
        while (!st.empty()) {
            right[st.peek()] = n;
            st.pop();
        }
        st.clear();
        for (int j = n - 1; j >= 0; j--) {
            while (!st.empty() && histogram[st.peek()] > histogram[j]) {
                left[st.peek()] = j;
                st.pop();
            }
            st.push(j);
        }
        while (!st.empty()) {
            left[st.peek()] = -1;
            st.pop();
        }
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, histogram[j] * (right[j] - left[j] - 1));
        }
        return ans;
    }

    static int largestRectangleHistogram2(int[] histogram) {
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

    public static void main(String[] args) {
        int[] histogram = {2, 3, 4, 2, 6, 5, 4, 5, 3};
        System.out.println(largestRectangleHistogram2(histogram));
    }
}
