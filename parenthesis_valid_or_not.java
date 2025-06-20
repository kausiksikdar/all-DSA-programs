import java.util.Stack;

public class parenthesis_valid_or_not {
    static boolean parenthesisValidOrNot(String paren){
        int n=paren.length();
        Stack<Character> st=new Stack<>();
        for (int j=0;j<n;j++){
            if (paren.charAt(j)=='(')
                st.push(paren.charAt(j));

            else
            {
                if (st.empty())
                    return false;

                else
                    st.pop();
            }
        }
        return st.empty();
    }
    static boolean parenthesisValidOrNot2(String paren){
        int n=paren.length();
        int left=0;
        for (int j=0;j<n;j++){
            if (paren.charAt(j)=='(') left++;
            else {
                if (left==0)
                    return false;

                else
                    left--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String paren="((())())";
        System.out.println(parenthesisValidOrNot2(paren));
    }
}
