public class longest_prefix_suffix {
    static int longestPrefixSuffix(String s){
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
        return lps[lps.length-1];
    }
    public static void main(String[] args) {
        String s="ABCDEABCD";
        System.out.println(longestPrefixSuffix(s));
    }
}
