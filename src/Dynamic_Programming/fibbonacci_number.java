package Dynamic_Programming;
/*
     fibbonacci(number) = fibbonacci(number - 1) + fibbonacci(number - 2)
     TC = O(n)
     SC = O(1)
*/
public class fibbonacci_number {
    static int fibbonacci(int n)
    {
        int first = 0, second = 1;

        while(n-->1)
        {
            int third = first+second;
            first = second;
            second = third;
        }
        return second;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibbonacci(n));
    }
}
