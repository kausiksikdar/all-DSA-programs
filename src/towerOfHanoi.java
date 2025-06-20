import java.util.Scanner;
public class towerOfHanoi {
    static int towerOfHanoi(int k, char source, char destination, char auxilary){
        if(k==1){
            return 1;
        }
        int step1 = towerOfHanoi(k-1,source,auxilary,destination);
        int step2 = 1;
        int step3 = towerOfHanoi(k-1,auxilary,destination,source);
        int answer = step1+step2+step3;
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the no. of discs...");
        char s,a,d;
        int n = sc.nextInt();
        System.out.println(towerOfHanoi(n,'s','d','a'));
    }

}
