public class remove_outer_most_parenthesis {
    static String removeOuterMostParenthesis(String str){
        StringBuilder ans=new StringBuilder();
        int count=0;
        for (int i=0;i< str.length();i++){
            if (str.charAt(i)=='(' && count>=1){
                ans.append('(');
            }
            if (str.charAt(i)=='('){
                count++;
            }
            if (str.charAt(i)==')' && count>1){
                ans.append(')');
            }
            if (str.charAt(i)==')'){
                count--;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String str="((()(())))";
        System.out.println(removeOuterMostParenthesis(str));
    }
}
