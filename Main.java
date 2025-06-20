class person {
    int age;
    Integer er=30;
    String title;
    Character e = 'k';
    char op;
    boolean ty = true;
    public int fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
public class Main{
    public static void main(String[] args) {
        person Kausik = new person();
        System.out.print(" "+Kausik.age);
        System.out.print(" "+Kausik.er);
        System.out.print(" "+Kausik.title);
        System.out.print(" "+Kausik.e);
        System.out.print(" "+Kausik.op);
        System.out.print(" " + Kausik.ty);
        System.out.println(" "+Kausik.fact(5));
    }
}
