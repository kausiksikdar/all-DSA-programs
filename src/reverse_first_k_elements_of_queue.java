import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverse_first_k_elements_of_queue {
    static Queue<Integer> reverse(Queue<Integer> qe, int n){
        Stack<Integer> st=new Stack<>();
        int x = qe.size()-n;
        while (n!=0){
            st.push(qe.peek());
            qe.remove();
            n--;
        }
        while (!st.empty()){
            qe.add(st.peek());
            st.pop();
        }
        while (x!=0){
            qe.add(qe.peek());
            qe.remove();
            x--;
        }
        return qe;
    }
    public static void main(String[] args) {
        Queue<Integer> qe=new LinkedList<>();
        qe.add(12);
        qe.add(23);
        qe.add(89);
        qe.add(9);
        qe.add(92);
        // 12 23 89 9 92
        int n = 2;
        Queue<Integer> ans = reverse(qe,n);
        while (!ans.isEmpty()){
            System.out.print(ans.peek()+" ");
            ans.remove();
        }
    }
}
