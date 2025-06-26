package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class get_minimum_at_top {
    static void swap(ArrayList<Integer> answer, int j, int k) {
        int temp = answer.get(j);
        answer.set(j, answer.get(k));
        answer.set(k, temp);
    }

    static void reverse(ArrayList<Integer> answer) {
        int j = 0, k = answer.size() - 1;
        while (k > j) {
            swap(answer, j, k);
            j++;
            k--;
        }
    }

    static ArrayList<Integer> getMinimumAtTop(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int j = 0; j < n; j++) {
            if (st.empty())
                st.push(arr[j]);

            else
                st.push(Math.min(arr[j], st.peek()));
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while (!st.empty()) {
            answer.add(st.peek());
            st.pop();
        }

        reverse(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 6, 0, 3};
        System.out.println(getMinimumAtTop(arr));
    }

}
