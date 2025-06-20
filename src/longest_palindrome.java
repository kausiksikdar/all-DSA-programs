public class longest_palindrome {
    static int longestPalindrome(String s){
        int n=s.length();
        int[] lower=new int[26];
        int[] upper=new int[26];
        for(int i=0;i<n;i++){
            if(s.charAt(i)>='a'){
                lower[s.charAt(i)-'a']++;
            }
            else {
                upper[s.charAt(i)-'A']++;
            }
        }
        int count=0;
        boolean odd=false; //It represents that any char present in string is odd no. of times or not
        for(int i=0;i<26;i++){
            if(lower[i]%2==0) count+=lower[i]; //If any char presents in even no of time directly add it
            else {
                count+=lower[i]-1;//If any char presents in odd no of time directly add it subtracting -1 and check the odd flag as true
                odd=true;
            }
        }
        for(int i=0;i<26;i++){
            if(upper[i]%2==0) count+=upper[i];
            else {
                count+=upper[i]-1;
                odd=true;
            }
        }
        if(odd) count++; //If odd flag is true that means there must be a char which presents in the string in odd no so finally add 1
        return count;
    }
    public static void main(String[] args) {
        String s="aabbcd";
        System.out.println(longestPalindrome(s));
    }
}
