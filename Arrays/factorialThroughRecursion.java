package Arrays;

import java.util.*;
public class factorialThroughRecursion {
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k;
        k=sc.nextInt();
        System.out.println(fact(k));
    }
}
