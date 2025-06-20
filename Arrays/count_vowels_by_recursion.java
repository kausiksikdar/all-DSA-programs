package Arrays;

public class count_vowels_by_recursion {
    static int countVowel(String s, int i){
        if(i==-1) return 0;
        if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') return 1+countVowel(s,i-1);
        else return countVowel(s,i-1);
    }
    public static void main(String[] args) {
        String s="vowel";
        System.out.println(countVowel(s,s.length()-1));
    }
}
