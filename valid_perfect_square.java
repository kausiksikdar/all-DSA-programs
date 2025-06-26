import java.util.Scanner;

public class valid_perfect_square {
    static boolean validPerfectSquare(int num){
        if(num<=1) return true;
        int start=0,end=num/2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid*mid==num) return true;
            else if(mid*mid<num) {
                start=mid+1;
            }
            else end = mid-1;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println(validPerfectSquare(a));
    }
}
