import java.util.Stack; // I i

public class reverse_array_by_stack {
    static char[] reverse(char[] arr){
        int n=arr.length;
        Stack<Character> st=new Stack<>();
        for (int j=0;j<n;j++){
            st.push(arr[j]);
        }
        char[] ans=new char[n];
        for (int j=0;j<n;j++){
            ans[j]=st.peek();
            st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        char[] arr={'h','e','l','l','o'};
        char[] ans=reverse(arr);
        for (int j=0;j<ans.length;j++){
            System.out.print(ans[j]+" ");
        }
    }
}
