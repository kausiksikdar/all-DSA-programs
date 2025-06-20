import java.util.*;
public class ifElse {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int result;
      int a = sc.nextInt();
      int b = sc.nextInt();
      char op = sc.next().charAt(0);
      switch (op){
          case '+':
              result = a+b;
              System.out.println(result);
              break;
          case '-':
              result = a-b;
              System.out.println(result);
              break;
          case '*':
              result = a*b;
              System.out.println(result);
              break;
          case '/':
              result = a/b;
              System.out.println(result);
              break;
          default:
              System.out.println("Enter correct operator");
                 break;
      }
    }
}
