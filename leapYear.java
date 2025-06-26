import java.util.Scanner;

public class leapYear {
    static void leapYear(int n){
        if(n%400==0){
            System.out.println("Leap year");
        }
      else if(n%4==0 && n%100!=0){
                System.out.println("Leap Year");
        }
        else System.out.println("Not a Leap Year");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        leapYear(k);
    }
}
