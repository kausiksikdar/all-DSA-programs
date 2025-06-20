import java.util.Stack;

public class maximum_of_minimum_for_every_window_size {
    static int[] maxOfMin(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        int range;
        Stack<Integer> st=new Stack<>();
        for (int j=0;j<n;j++){
            while (!st.empty() && arr[st.peek()]>arr[j]){  //10,20,15,50,10,70,30
                int index=st.peek();
                st.pop();
                if (st.empty()){
                    range=j;
                }
                else {
                    range=j-st.peek()-1;
                }
                ans[range-1]=Math.max(arr[range-1],arr[index]);
            }
            st.push(j);
        }
        while (!st.empty()){
            int index=st.peek();
            st.pop();
            if (st.empty()){
                range=n;
            }
            else {
                range=n-st.peek()-1;
            }
            ans[range-1]=Math.max(ans[range-1],arr[index]);
        }
        for (int j=n-2;j>=0;j--){
            ans[j]=Math.max(ans[j],ans[j+1]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={10,20,15,50,10,70,30};
        int[] ans=maxOfMin(arr);
        for (int j=0;j<ans.length;j++){
            System.out.print(ans[j]+" ");
        }
    }
}
