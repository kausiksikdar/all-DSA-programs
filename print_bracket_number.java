import java.util.ArrayList;
import java.util.Stack;

public class print_bracket_number {
    static ArrayList<Integer> printBracketNumber(String str){
        int n=str.length();
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int cnt=0;
        for (int j=0;j<n;j++){
            if (str.charAt(j)=='('){
                cnt++;
                st.push(cnt);
                ans.add(cnt);
            }
            else if (str.charAt(j)==')'){
                ans.add(st.peek());
                st.pop();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str="(aa(bcd))p(ef)";
        System.out.println(printBracketNumber(str));
    }
}
