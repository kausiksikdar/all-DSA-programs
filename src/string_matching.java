public class string_matching {
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
    static int stringMatching(String str1, String str2){
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
        if(second==str2.length()) return first-second;
        return -1;
    }
    public static void main(String[] args) {
        String str1="kausik";
        String str2="si";
        System.out.println(stringMatching(str1,str2));
    }
}
