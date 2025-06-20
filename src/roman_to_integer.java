public class roman_to_integer {
    static int num(char ch){
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
    static int romanToInteger(String s){
        int index=0,sum=0;
        while (index<s.length()-1){
            if(num(s.charAt(index))>=num(s.charAt(index+1))){
                sum+=num(s.charAt(index));
            }
            else sum-=num(s.charAt(index));
            index++;
        }
        sum+=num(s.charAt(s.length()-1));
        return sum;
    }
    public static void main(String[] args) {
        String s="XL";
        System.out.println(romanToInteger(s));
    }
}
