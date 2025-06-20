import java.util.Scanner;

public class reverse_recursion {
    static String reverse(String s){
        if(s.isEmpty()) return "";
        String small_ans = reverse(s.substring(1));
        char curr_char = s.charAt(0);
        return small_ans+curr_char;
    }
    static String reverse2(String s, int idx){
        if(s.length()==idx) return "";
        String small_ans = reverse2(s,idx+1);
        char curr_char = s.charAt(idx);
        return small_ans+curr_char;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println();
        System.out.println(reverse(s));
        System.out.println();
       System.out.println(reverse2(s,0));
    }
}
