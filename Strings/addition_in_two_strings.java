package Strings;

public class addition_in_two_strings {
    static String addition(String num1, String num2){
        StringBuilder ans=new StringBuilder();
        int carry=0,idx1=num1.length()-1,idx2=num2.length()-1;
        while (idx2>=0){
           int sum=0;
            sum+=(num1.charAt(idx1)-'0')+(num2.charAt(idx2)-'0')+carry;
            carry=sum/10;
            char ch=(char)('0'+sum%10);
            ans.append(ch);
            idx1--;
            idx2--;
        }
        while (idx1>=0){
           int sum=0;
            sum+=(num1.charAt(idx1)-'0')+carry;
            carry=sum/10;
            char ch=(char)('0'+sum%10);
            ans.append(ch);
            idx1--;
        }
        if(carry!=0){
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
    public static void main(String[] args) {
        String num1="54321";
        String num2="99";
        if(num1.length()<num2.length()){
            System.out.println(addition(num2,num1));
        }
        else {
            System.out.println(addition(num1,num2));
        }
    }
}
