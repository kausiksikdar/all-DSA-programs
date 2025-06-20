import java.util.Scanner;

public class print10to1ThroughRecursion {
    static void print1to10(int k){
        if(k==1){
            System.out.println(1);
            return;
        }
        System.out.println(k);
        print1to10(k-1);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print1to10(n);
    }
}
