import java.util.Scanner;
class Algebra {
    int a;
    int b;
    Algebra(int x, int y) {
        System.out.println("Constructer called");
        a = x;
        b = y;
    }
    int add(){
        return a+b;
    }
    int sub() {return a-b;}
    int mul(){
        return a*b;
    }
    int div(){
        return a/b;
    }
    int rem(){
        return a%b;
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        Algebra sum = new Algebra(p,q);
        System.out.println(sum.add());
        System.out.println(sum.sub());
        System.out.println(sum.mul());
        System.out.println(sum.div());
        System.out.println(sum.rem());
    }
}
