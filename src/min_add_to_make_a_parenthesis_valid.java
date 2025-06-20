import java.util.Stack;

public class min_add_to_make_a_parenthesis_valid {
    static int minAddToMakeAParenthesisValid(String str){
        int n=str.length();
        int cnt=0;
        Stack<Character> st=new Stack<>();
        for (int j=0;j<n;j++){
            if (str.charAt(j)=='(') st.push(str.charAt(j));
            else {
                if (st.empty()) cnt++;
                else st.pop();
            }
        }
        return cnt+st.size();
    }
    static int minAddToMakeAParenthesisValid2(String paren){
        int n=paren.length();
        int left=0;
        for (int j=0;j<n;j++){
            if (paren.charAt(j)=='(') left++;
            else {
                    left--;
            }
        }
        return Math.abs(left);
    }
    public static void main(String[] args) {
        String str="((())())((";
        System.out.println(minAddToMakeAParenthesisValid(str));
    }
}
