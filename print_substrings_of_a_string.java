import java.util.ArrayList;

public class print_substrings_of_a_string {
    static ArrayList<String> subsequences(String s, String curr_ans, ArrayList<String> ans){
        if(s.isEmpty()){
            ans.add(curr_ans);
           return ans;
        }
        char curr_char = s.charAt(0);
        String remaining = s.substring(1);
        subsequences(remaining , curr_ans+curr_char,ans);
        subsequences(remaining,curr_ans,ans);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<String> ans=subsequences("abc","",new ArrayList<>());
        System.out.println(ans);
    }
}
