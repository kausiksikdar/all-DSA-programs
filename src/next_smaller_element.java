import java.util.Stack;

public class next_smaller_element {
    static int[] nextSmallerElement2(int[] arr){ //Traverse from the last
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int j=n-1;j>=0;j--){
            //if arr[st.peek()]>=arr[j] i.e. the present element we are processing is not the next smaller of history
            while (!st.empty() && arr[st.peek()]>=arr[j]) //7,9,2,2,10,14,8,3,6,9
                st.pop();
            //Answer modification
            if (!st.empty())
                ans[j]=arr[st.peek()];
            //if not then add the element to the stack
            st.push(j);
        }
        for (int j=0;j<n;j++){
            if (ans[j]==0)
                ans[j]=-1;
        }
        return ans;
    }
    static int[] nextSmallerElement(int[] arr){ //Traverse from the first
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int j=0;j<n;j++){
            //if arr[st.peek()]>arr[j] i.e. the present element we are processing is smaller than what we store in history i.e. that element is the answer of the history
            while (!st.empty() && arr[st.peek()]>arr[j]){
                ans[st.peek()]=arr[j];
                st.pop();
            }
            //if not then add the element to the stack
            st.push(j);
        }
        for (int j=0;j<n;j++){
            if (ans[j]==0)
                ans[j]=-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={7,9,2,2,10,14,8,3,6,9};
        int[] ans=nextSmallerElement2(arr);
        for (int j:ans){
            System.out.print(j+" ");
        }
    }
}
