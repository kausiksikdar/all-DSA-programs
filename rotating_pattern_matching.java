public class rotating_pattern_matching {
    static int[] longestPrefixSuffix(String s){
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
    static boolean stringMatching(String str1, String str2){
        int[] lps=longestPrefixSuffix(str2);
        int first=0,second=0;
        while (first<str1.length() && second<str2.length()){
            if (str1.charAt(first)==str2.charAt(second)){
                first++;
                second++;
            }
            else {
                if (second==0){
                    first++;
                }
                else {
                    second=lps[second-1];
                }
            }
        }
        if(second==str2.length()) return true;
        return false;
    }
    static boolean circularPatternMatching(String s, String str){
        StringBuilder str1=new StringBuilder(s);
        StringBuilder gtr=str1.append(str1);
        if(stringMatching(gtr.toString(),str)) return true;
        return false;
    }
    public static void main(String[] args) {
        String s="cdeabroab";
        String str="abcde";
        System.out.println(circularPatternMatching(s,str));
    }
}
