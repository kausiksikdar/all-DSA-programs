package Strings;

public class add_char_to_make_a_string_palindrome {
    static int[] longestPrefixSuffix(StringBuilder s){
        int[] lps=new int[s.length()];
        int pre=0,suf=1;
        while (suf<s.length()){
            if (s.charAt(pre) == s.charAt(suf)) {
                lps[suf]=pre+1;
                pre++;
                suf++;
            }
            else {
                if(pre==0){
                    lps[suf]=0;
                    suf++;
                }
                else {
                    pre=lps[pre-1];
                }
            }
        }
        return lps;
    }
    static int addCharToMakeAStringPalindrome(String s){
        StringBuilder str=new StringBuilder(s);
        StringBuilder gtr=new StringBuilder(str);
        gtr.append(str.reverse());
        gtr.insert(s.length(),'$');
        int[] lps=longestPrefixSuffix(gtr);
        return s.length()-lps[lps.length-1];
    }
    public static void main(String[] args) {
        String s="ROORPS";
        System.out.println(addCharToMakeAStringPalindrome(s));
    }
}
