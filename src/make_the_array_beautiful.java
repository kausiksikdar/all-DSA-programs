import java.util.ArrayList;
import java.util.Stack;

public class make_the_array_beautiful { // i I
    static ArrayList<Integer> makeTheArrayBeautiful(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int j = 0; j < arr.length; j++) {
            if (st.empty()) {
                st.push(arr[j]);
            } else if (arr[j] >= 0) {
                if (st.peek() >= 0) st.push(arr[j]);
                else st.pop();
            } else {
                if (st.peek() < 0) st.push(arr[j]);
                else st.pop();
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while (!st.empty()) {
            answer.add(st.peek());
            st.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -1, -4, 3, 2, -1};

        System.out.println(makeTheArrayBeautiful(arr));
    }
}
