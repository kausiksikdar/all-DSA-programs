import java.util.Stack;

public class smallest_no_on_left {
    static int[] smallerNoOnLeft(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for (int j=n-1;j>=0;j--){
            while (!st.empty() && arr[st.peek()]>arr[j]){
                ans[st.peek()]=arr[j];
                st.pop();
            }
            st.push(j);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={4,13,11,5,9,7,8,6};
        int[] ans=smallerNoOnLeft(arr);
        int j=0;
        while (j<ans.length){
            System.out.print(ans[j]+" ");
            j++;
        }
    }
}
