public class palindromeString {
    //time complexity = O(n^2)
    //As string concatenation is taking linear time and n times recursion is done
    static String reverse(String s){
        if(s.isEmpty()) return "";
        String small_ans = reverse(s.substring(1));
        char curr_char = s.charAt(0);
        return small_ans+curr_char;
    }
    //time complexity = O(n)
    // n times recursion is done
    static boolean isPalindrome(String s, int l, int r){
        if(l>=r) return true;
        boolean next_string = isPalindrome(s,l+1,r-1);
        return s.charAt(l) == s.charAt(r - 1) && next_string;
    }
    public static void main(String[] args) {
        String s = "level";
        String rev = reverse(s);
        if(rev.equals(s)) System.out.println(s+" is palindrome");
        else System.out.println("no");
        System.out.println();
        System.out.println(isPalindrome(s,0,s.length()));
    }
}
