import java.util.Stack;

public class next_greater_element_2 {
    static int[] nextGreaterElement2(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int j=0;j<2*n;j++){
            //if arr[st.peek()]<arr[j] i.e. the present element we are processing is greater than what we store in history i.e. that element is the answer of the history
            while (!st.empty() && arr[st.peek()]<arr[j%n]){
                ans[st.peek()]=arr[j%n];
                st.pop();
            }
            //if not then add the element to the stack
            st.push(j%n);
        }
        for (int j=0;j<n;j++){
            if (ans[j]==0)
                ans[j]=-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={6,10,7,4,8,9,4};
        int[] ans=nextGreaterElement2(arr);
        int j=0;
        while (j<ans.length){
            System.out.print(ans[j]+" ");
            j++;
        }
    }
}
