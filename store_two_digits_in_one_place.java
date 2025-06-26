import java.util.Scanner;

public class store_two_digits_in_one_place {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the no.");
        int no = sc.nextInt();
        System.out.println("Please enter the occurrence of that no.");
        int occurrence = sc.nextInt();
        int reference = no+1;
        int ans = occurrence*reference+no;
        System.out.println(ans);
        System.out.println("If we simply take modulus of the ans with reference we get the actual no. -> ans%reference");
        System.out.println(ans%reference);
        System.out.println("If we simply take division of the ans with reference we get the occurrence of the no. -> ans/reference");
        System.out.println(ans/reference);
    }
}
