package Arrays;

public class check_pangram {
    static boolean checkPangram(String s){
        int[] count=new int[26];
        int index=0;
        while (index<s.length()){
            if (s.charAt(index)!=' ') {
                count[s.charAt(index) - 'a'] = 1;
            }
            index++;
        }
        for (int i=0;i<26;i++){
            if(count[i]==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="the quick brown fox jumps over the lazy dog";
        System.out.println(checkPangram(s));
    }
}
