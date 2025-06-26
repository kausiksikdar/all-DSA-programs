package Arrays;

import java.util.ArrayList;

public class element_greater_n3_times {
    static ArrayList<Integer> majorityElement(int[] arr){
        int n= arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int cnt1=0,ele1=Integer.MIN_VALUE,cnt2=0,ele2=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if (cnt1==0 && arr[i]!=ele2){
                cnt1=1;
                ele1=arr[i];
            }
            else if (cnt2==0 && arr[i]!=ele1){
                cnt2=1;
                ele2=arr[i];
            }
            else if (ele1==arr[i]){
                cnt1++;
            }
            else if (ele2==arr[i]){
                cnt2++;
            }
            else {
                cnt2--;
                cnt1--;
            }
        }
        cnt2=0;
        cnt1=0;
        for (int i=0;i<n;i++){
            if (ele1==arr[i]) cnt1++;
            if (ele2==arr[i]) cnt2++;
        }
        if (cnt1>=n/3+1) ans.add(ele1);
        if (cnt2>=n/3+1) ans.add(ele2);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={3,2};
        System.out.println(majorityElement(arr));
    }
}
