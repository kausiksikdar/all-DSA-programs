import java.util.Scanner;

public class removeA_recursion {
    static String removeA(String s, int idx){
        if(idx==s.length()) return "";
        String smallAns = removeA(s,idx+1);
        char curr_Char = s.charAt(idx);
        if(curr_Char!='a') return curr_Char+smallAns;
        else return smallAns;
    }
    static String removeA2(String s){
        if(s.isEmpty()) return "";
        String smallAns = removeA2(s.substring(1));
        char curr_Char = s.charAt(0);
        if(curr_Char!='a') return curr_Char+smallAns;
        else return smallAns;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(removeA2(s));
    }
}
