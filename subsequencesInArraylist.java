import java.util.ArrayList;

public class subsequencesInArraylist {
    static ArrayList<String> getSSQ(String s){
        ArrayList<String> ans = new ArrayList<>();
        if(s.isEmpty())
        {
            ans.add("");
            return ans;
        }
        ArrayList<String> small_ans = getSSQ(s.substring(1));
        char curr_char = s.charAt(0);
        for (String ss: small_ans) {
           ans.add(ss);
           ans.add(curr_char+ss);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> ans = getSSQ(s);
        for (String ss:ans) {
            System.out.println(ss);
        }
    }
}
