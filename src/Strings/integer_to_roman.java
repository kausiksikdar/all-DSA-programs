package Strings;

import java.util.Scanner;

public class integer_to_roman {
    static String IntToRoman(int n){
        StringBuilder ans=new StringBuilder();
        int[] fixedValues={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] fixedstring={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i=0;i<fixedValues.length;i++){
            while (n>=fixedValues[i]){
                n-=fixedValues[i];
                ans.append(fixedstring[i]);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        int n;

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        System.out.println(IntToRoman(n));
    }
}
