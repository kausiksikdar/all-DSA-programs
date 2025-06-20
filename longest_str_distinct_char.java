import java.util.ArrayList;

public class longest_str_distinct_char {
    static int distinctChecker(String s){
        int n=s.length();
        int distinct=0;
        int[] checker=new int[26];
        for (int j=0;j<n;j++){
           checker[s.charAt(j)-'a']++;
        }
        for (int j=0;j<26;j++){
            if (checker[j]!=0) distinct++;
        }
        return distinct;
    }
    static ArrayList<String> generate(String str1, int n, int index, ArrayList<String> ans, String answer){
        if (index==n){
             ans.add(answer);
             return ans;
        }
        generate(str1,n,index+1,ans,answer+str1.charAt(index));
        generate(str1,n,index+1,ans,answer);
        return ans;
    }
    //TC=O(Max(m*2^m,n*2^n))
    public static void main(String[] args) {
        String str1 = "abbc";
        String str2 = "dddd";
        ArrayList<String> ans1 = generate(str1, str1.length(), 0, new ArrayList<>(), ""); //O(2^n)
        ArrayList<String> ans2 = generate(str2, str2.length(), 0, new ArrayList<>(), ""); //O(2^m)
        int distinct1 = 0;
        int distinct2 = 0;
        String final1 = "";
        String final2 = "";
        for (int j = 0; j < ans1.size(); j++) {  //O(n*2^n)
            if (distinct1 < distinctChecker(ans1.get(j))) {
                distinct1 = distinctChecker(ans1.get(j));
                final1 = ans1.get(j);
            }
        }
        for (int j = 0; j < ans2.size(); j++) {  //O(m*2^m)
            if (distinct2 < distinctChecker(ans2.get(j))) {
                distinct2 = distinctChecker(ans2.get(j));
                final2 = ans2.get(j);
            }
        }
        int check1 = distinctChecker(final1);
        int check2 = distinctChecker(final2);
        if (check1 == check2) {
            if (final1.length() > final2.length()) System.out.println(final1);
            else System.out.println(final2);
        } else {
            if (check1 > check2) System.out.println(final1);
            else System.out.println(final2);
        }
    }
}
