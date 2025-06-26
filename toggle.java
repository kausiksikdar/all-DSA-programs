import java.util.*;
public class toggle {
    /*
    * Capital A -> 65
    * Small a -> 97
    * A-a = 32
    * If the letter is small make it capital by adding 32 and vice versa
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        for(int i=0;i<sb.length();i++){
            boolean flag = true;
            char ch = sb.charAt(i);
            if(ch==' ') continue;
            if((int)ch>=65&&(int)ch<=122){
                if((int)ch>=97) flag = false;
                if(flag){
                    int asci = (int)ch;
                    asci+=32;
                    char dh = (char)asci;
                    sb.setCharAt(i,dh);
                }
                else{
                    int asci = (int)ch;
                    asci-=32;
                    char dh = (char)asci;
                    sb.setCharAt(i,dh);
                }
            }
        }
        System.out.println(sb);
    }
}