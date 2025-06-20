package Stacks;

import java.util.Queue;
import java.util.Stack;

public class implement_Qe_by_stack {
    public static class Qe{
        Stack<Integer> st1=new Stack<Integer>();
        Stack<Integer> st2=new Stack<Integer>();
        boolean empty(){
            return st1.empty() && st2.empty();
        }
        void add(int x){
            st1.push(x);
        }
        int remove(){
            if (empty()) return 0;
            if (!st2.empty()){
                int ele=st2.peek();
                st2.pop();
                return ele;
            }
            else {
                while (!st1.empty()){
                    st2.push(st1.peek());
                    st1.pop();
                }
                int ele=st2.peek();
                st2.pop();
                return ele;
            }
        }
        int peek(){
            if (empty()) return 0;
            if (!st2.empty()){
                return st2.peek();
            }
            else {
                while (!st1.empty()){
                    st2.push(st1.peek());
                    st1.pop();
                }
                return st2.peek();
            }
        }
    }

    public static void main(String[] args) {
        Qe q = new Qe();
        q.add(23);
        q.add(34);
        q.add(24);
        q.add(65);
        q.remove();
        while (!q.empty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
