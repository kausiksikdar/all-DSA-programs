package Arrays;

import java.util.*;
public class fibonacci {
    static int fibo(int k){
        if(k==1 || k==0){
            return k;
        }
        return fibo(k-1)+fibo(k-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //To print only nth term
        System.out.println(fibo(n));
        //To print the fibbonacci series
        for(int i=0;i<=n;i++){
            System.out.print(fibo(i)+" ");
        }
    }
}
/*
  Time Complexity = no. of method call * time taken in one call
                  =           n        *      constant
                  =                    nc
                  = O(n)
 Space Complexity =
 */