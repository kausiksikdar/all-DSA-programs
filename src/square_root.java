import java.util.Scanner;

public class square_root {
    static int squareRoot(int n){
        int ans = 0;
        if(n<0) return -1;
        if(n==0 || n==1) return n;
        for(int i=1;i<=n/2;i++){
          if(i*i<=n){
              ans = i;
          }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(squareRoot(k));
    }
}
