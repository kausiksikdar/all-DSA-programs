package Strings;

public class Atoi {
    static int atoi(String s){
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int ans = 0, i = 0;
        boolean neg = s.charAt(0) == '-';

        if (neg) {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return neg ? -ans : ans;
    }
    public static void main(String[] args) {
        String s="    -42";
        System.out.println(atoi(s));
    }
}
