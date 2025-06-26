import java.util.*;
public class string {
    public static void main(String[] args) {
        String s1 = "Hello";
        String x = "Hello";
        x = "Mello";
        String s2 = "Hello";
//        String d = new String("Hello");
//        System.out.println(s1.contains("o"));
//        System.out.println(s1.toLowerCase());
//        System.out.println(s1.concat(x));
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.compareTo(s2));
//        System.out.println(s1.compareTo(x));
//        System.out.println(x.compareTo(s1));
//        System.out.println(s1.charAt(0));
//        System.out.println(s1.indexOf('o'));
//        System.out.println(s1.toCharArray());
//        System.out.println(s1+x);
          StringBuilder str = new StringBuilder("Hello");
          System.out.println(str);
//          str.setCharAt(0,'k');
//          str.deleteCharAt(0);
//          str.insert(2,'u');
//         System.out.println(str);
//         str.reverse();
//         str.replace(0,3,"goat");
//         str.delete(0,3);
//         str.append("Goodbye");
//        System.out.println(str.substring(2));
        str.append("op");
        StringBuilder[] arr={new StringBuilder("oooo")};
        str.append(arr[0]);
        System.out.println(str);
        int xp=('1'-'0');
        System.out.println(--xp);
    }
}
