import java.util.Scanner;

public class Power_Of_Two {
    static boolean powerOfTwo(int n){
       int flag = 1;
        for(int i=1;i<n;i*=2){
            if(n%i!=0){
             flag = 0;
             break;
            }
        }
        if(flag==1){
            return true;
        }
       else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        boolean p = powerOfTwo(k);
        System.out.println(p);
    }
}
