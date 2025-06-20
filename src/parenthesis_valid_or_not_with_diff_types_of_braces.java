import java.util.Stack;

public class parenthesis_valid_or_not_with_diff_types_of_braces {
    static boolean parenthesisValidOrNotWithDiffTypesOfBraces(String str){
        int n=str.length();
        Stack<Character> st=new Stack<>();
        for (int j=0;j<n;j++){
            if (str.charAt(j) == '(' || str.charAt(j) == '{' || str.charAt(j)=='[')
                st.push(str.charAt(j));

            else {
                if (st.empty()) return false;
                else if (str.charAt(j)==')'){
                    if (st.peek()!='(') return false;
                    else st.pop();
                }
                else if (str.charAt(j)=='}'){
                    if (st.peek()!='{') return false;
                    else st.pop();
                }
                else if (str.charAt(j)==']'){
                    if (st.peek()!='[') return false;
                    else st.pop();
                }
            }
        }
        if(st.size()!=0) return false;
        return true;
    }
    public static void main(String[] args) {
        String str="(()){}[(])";
        System.out.println(parenthesisValidOrNotWithDiffTypesOfBraces(str));
    }
}
