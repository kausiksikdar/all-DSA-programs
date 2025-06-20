import java.util.Stack;

public class trapping_rain_water {
    static int[] nextGreaterElement(int[] arr){ //Traverse from the first
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int j=0;j<n;j++){
            //if arr[st.peek()]<arr[j] i.e. the present element we are processing is greater than what we store in history i.e. that element is the answer of the history
            while (!st.empty() && arr[st.peek()]<arr[j]){
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
    static int trappingRainWaterStack(int[] arr){
        int n=arr.length;
        int maxHeight=-1000, maxi=-1,minHeight=arr[0],water=0;
        for (int j=0;j<n;j++){
            if (arr[j]>maxHeight){
                maxHeight=arr[j];
                maxi=j;
            }
        }
        int[] NGR=nextGreaterElement(arr);
        for (int j=1;j<maxi;j++){
            if (arr[j]>minHeight) minHeight=arr[j];
            if (NGR[j]>arr[j]) water+=minHeight-arr[j];
        }
        minHeight=arr[n-1];
        for (int j=n-2;j>maxi;j--){
            if (minHeight<arr[j]) minHeight=arr[j];
            if (NGR[j]>arr[j]) water+=minHeight-arr[j];
        }
        return water;
    }
    static int trappingRainWater(int[] arr){
        int n= arr.length;
        int index=-1,maxHeight=arr[0],water=0,maxLeft=0,maxRight=0;
        for(int i=0;i<n;i++){
            if(arr[i]>maxHeight){
                maxHeight=arr[i];
                index=i;
            }
        }
        int st=0,end=n-1;
        while (st<index){
            if(maxLeft>arr[st]){
                water+=maxLeft-arr[st];
                st++;
            }
            else {
                maxLeft=arr[st];
                st++;
            }
        }
        while (end>index){
            if(maxRight>arr[end]){
                water+=maxRight-arr[end];
                end--;
            }
            else {
                maxRight=arr[end];
                end--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        int x=trappingRainWaterStack(arr);
        System.out.println(x);
    }
}
