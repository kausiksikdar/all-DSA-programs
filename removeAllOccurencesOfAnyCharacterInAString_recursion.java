import java.security.spec.RSAOtherPrimeInfo;

public class removeAllOccurencesOfAnyCharacterInAString_recursion {
    static String remainingString(String s, int pos, char ch){
        if(pos==s.length()) return "";
        String ans="";
        if(s.charAt(pos)!=ch) ans+=s.charAt(pos);
        String pre_ans=remainingString(s,pos+1,ch);
        return ans+pre_ans;
    }

    public static void main(String[] args) {
        String s = "abcax";
        char ch = 'a';
        String p = remainingString(s,0,ch);
        System.out.println(p);
    }
}
