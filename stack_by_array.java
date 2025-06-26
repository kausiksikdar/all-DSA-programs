public class stack_by_array {
    public static class Stack{
        int size;
        int top;
        int[] arr;
        boolean flag=true;
        Stack(int s){
            size=s;
            top=-1;
            arr=new int[s];
        }
       void push(int data){
            if (top==size){
                System.out.println("Stack overflow");
                return;
            }
            else {
                top++;
                arr[top]=data;
                System.out.println("Pushed "+data+" to stack");
                flag=false;
            }
        }
        void pop(){
            if (top==-1){
                System.out.println("Stack underflow");
            }
            else {
                System.out.println("popped "+arr[top]+" from the stack");
                top--;
            }
        }
        int peak(){
            if (top==-1){
                System.out.println("Stack is empty");
                return -1;
            }
            else {
                return arr[top];
            }
        }
        boolean isEmpty(){
            return top==-1;
        }
        int getSize(){
            return top+1;
        }
    }

    public static void main(String[] args) {
        Stack s=new Stack(5);
        s.push(20);
        s.push(30);
        s.push(85);
        System.out.println(s.peak());
    }
}
