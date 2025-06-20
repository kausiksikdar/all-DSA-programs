package Arrays;

import java.util.ArrayList;

public class generate_parenthesis {
    static ArrayList<String> generateParenthesis(int n, int left, int right, ArrayList<String> ans, String temp){
        StringBuilder tempt=new StringBuilder(temp);
        if (left+right==2*n){
            ans.add(tempt.toString());
            return ans;
        }
        if (left<n){
            tempt.append("(");
            generateParenthesis(n,left+1,right,ans,tempt.toString());
            tempt.deleteCharAt(tempt.length()-1);
        }
        if (right<left){
            tempt.append(")");
            generateParenthesis(n,left,right+1,ans,tempt.toString());
            tempt.deleteCharAt(tempt.length()-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n=3;
        ArrayList<String> ans=new ArrayList<>();
        String temp="";
        ArrayList<String> answer=generateParenthesis(n,0,0,ans,temp);
        System.out.println(answer);
    }
}
