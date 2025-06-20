import java.util.Scanner;
public class takingInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //By the method of nextline it reads after space
        //By the method of next it reads up to space
        String name = sc.nextLine();
        System.out.println("Your name is "+name);
        float a = sc.nextFloat();
        System.out.println("Your number is "+a);
    }
}
