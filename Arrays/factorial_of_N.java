package Arrays;

import java.util.ArrayList;

public class factorial_of_N {
    static void reverse(ArrayList<Integer> ans, int a, int b){
        int i=a,j=b-1;
        while (i < j) {
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
            i++;
            j--;
        }
    }
    static String factorialOfN(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(1);
        while (n>1){
            int carry=0,res,size= ans.size();
            for (int i=0;i<size;i++){
                res=ans.get(i)*n+carry;
                carry=res/10;
                ans.set(i,res%10);
            }
            while (carry!=0){
                ans.add(carry%10);
                carry/=10;
            }
            n--;
        }
        reverse(ans,0,ans.size());
        return ans.toString();
    }
    public static void main(String[] args) {
        int n=51;
        System.out.println(factorialOfN(n));
    }
}
