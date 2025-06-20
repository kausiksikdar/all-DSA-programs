package Strings;

import java.util.ArrayList;
import java.util.Stack;

public class background_string_compare {
    static void swap(ArrayList<Character> ans, int i, int j){
        char temp=ans.get(i);
        ans.set(i,ans.get(j));
        ans.set(j,temp);
    }
    static void reverse(ArrayList<Character> ans, int i, int j){
        while (i<=j) {
            swap(ans,i,j);
            i++;
            j--;
        }
    }
    static String actualString(String str){
        int n=str.length();
        Stack<Character> st=new Stack<>();
        for (int j=0;j<n;j++){
            if (str.charAt(j)!='#') st.push(str.charAt(j));
            else {
                if (st.empty()) return "";
                else st.pop();
            }
        }
        ArrayList<Character> ans=new ArrayList<>();
        int i=st.size();
        while (i!=0){
            ans.add(st.peek());
            st.pop();
            i--;
        }
        reverse(ans,0,ans.size()-1);
        return ans.toString();
    }
    public static void main(String[] args) {
        String str1="ab#c";
        String str2="ad#c";
        String s1=actualString(str1);
        String s2=actualString(str2);
        if (s1.equals(s2)) System.out.println("True");
        else System.out.println("False");
    }
}
