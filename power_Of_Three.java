public class power_Of_Three {
    static boolean ispowerOfThree(int n){
        if(n==1) return true;
        if(n%3!=0 || n==0) return false;
        return ispowerOfThree(n/3);
    }

    public static void main(String[] args) {
        System.out.println(ispowerOfThree(36));
    }
}
