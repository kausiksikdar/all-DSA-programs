import java.util.*;
public class primeNo {
   static boolean isPrime(int n){
        boolean flag = true;
        for (int i=2;i<n;i++){
            if(n%i==0){
                flag = false;
                break;
            }
        }
        if(flag==false){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        if(isPrime(n)){
            System.out.println("The no. is prime -> "+n);
        }
        else{
            System.out.println("Its not prime -> "+n);
        }
    }
}
