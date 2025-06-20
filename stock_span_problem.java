import java.util.Stack;

public class stock_span_problem {
    static int[] stockSpanProblem(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int j = n - 1; j >= 0; j--) {
            while (!st.empty() && arr[j] >= arr[st.peek()]) {
                ans[st.peek()] = st.peek() - j;
                st.pop();
            }
            st.push(j);
        }
        while (!st.empty()) {
            ans[st.peek()] = st.peek() + 1;
            st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 55, 70, 60, 75, 85};
        int[] stockSpan = stockSpanProblem(arr);
        for (int j = 0; j < stockSpan.length; j++) {
            System.out.print(stockSpan[j] + " ");
        }
    }
}
