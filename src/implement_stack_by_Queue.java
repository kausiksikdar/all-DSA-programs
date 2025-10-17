
import java.util.LinkedList;
import java.util.Queue;


public class implement_stack_by_Queue {
    public static class Stack {
        Queue<Integer> q1 = new LinkedList<>();

        boolean empty() {
            return q1.isEmpty();
        }

        void push(int x) {
            q1.add(x);
        }

        int pop() {
            if (empty()) return 0;
            else {
                int n = q1.size();
                while (n > 1) {
                    q1.add(q1.peek());
                    q1.remove();
                    n--;
                }
                int ele = q1.peek();
                q1.remove();
                return ele;
            }
        }
            int peek() {
                if (empty()) return 0;
                else {
                    int n = q1.size();
                    while (n > 1) {
                        q1.add(q1.peek());
                        q1.remove();
                        n--;
                    }
                    int ele = q1.peek();
                    q1.add(q1.peek());
                    q1.remove();
                    return ele;
                }
            }
    }
        public static void main(String[] args) {
            Stack st =new Stack();
            st.push(52);
            st.push(23);
            st.push(58);
            st.push(87);
            System.out.println(st.pop());
            System.out.println();
            while (!st.empty()){
                System.out.println(st.peek());
                st.pop();
            }
        }
}
