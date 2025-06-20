package Strings;

public class check_palindrome {
    static boolean checkPalindrome(String s, int st , int end){
        if (st>=end) return true;
        if(s.charAt(st)!=s.charAt(end)) return false;
        return checkPalindrome(s,st+1,end-1);
    }
    public static void main(String[] args) {
        String name="dad";
        System.out.println(checkPalindrome(name,0,name.length()-1));
    }
}
