public class sort_a_string {
    static String sortString(String s){
        String ans="";
        int[] count=new int[26];
        int index=0;
        while (index<s.length()){
            count[s.charAt(index)-'a']++;
            index++;
        }
        for (int i=0;i<26;i++){
            char ch=(char)('a'+i);
            while (count[i]!=0){
                ans+=ch;
                count[i]--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="abbacedfthrujklopei";
        System.out.println(sortString(s));
    }
}
