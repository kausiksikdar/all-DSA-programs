package Graphs;

public class Perfect_Sq {
    // helper: check if a number is a perfect square
    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static int numSquares(int n) {
        // case 1: n is a perfect square
        if (isPerfectSquare(n)) return 1;

        // case 2: check if n can be written as sum of 2 squares
        for (int i = 1; i * i <= n; i++) {
            int remainder = n - i * i;
            if (isPerfectSquare(remainder)) {
                return 2;
            }
        }

        // case 3: Legendre’s 3-square theorem check
        // reduce n by removing factors of 4
        int m = n;

        while (m % 4 == 0)
            m /= 4;

        if (m % 8 == 7)
            return 4;

        // case 4: otherwise, it's 3
        return 3;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
    }
}
