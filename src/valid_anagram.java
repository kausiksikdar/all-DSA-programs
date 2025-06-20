public class valid_anagram {
    static boolean validAnagram(String s, String t){
        int[] countS=new int[26];
        int[] countT=new int[26];
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            countS[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            countT[t.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            if(countS[i]==countT[i]) flag=true;
            else {
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(validAnagram(s,t));
    }
}
