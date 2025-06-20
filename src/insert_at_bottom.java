import java.util.Stack; // I i

public class insert_at_bottom {
    //TC=O(n) for traversing entire stack, SC=O(n) for creating extra 'temp' stack
    static Stack<Integer> insertElement(Stack<Integer> s, int x){
        Stack<Integer> temp=new Stack<>();
        while (!s.empty()){
            temp.push(s.peek());
            s.pop();
        }
        s.push(x);
        while (!temp.empty()){
            s.push(temp.peek());
            temp.pop();
        }
        return s;
    }
    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(8);
        System.out.println(insertElement(s,2));
    }
}
