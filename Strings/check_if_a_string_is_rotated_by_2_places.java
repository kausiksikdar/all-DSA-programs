package Strings;

public class check_if_a_string_is_rotated_by_2_places {
    static StringBuilder checkCLW(StringBuilder str1){
        StringBuilder ans=new StringBuilder();
        char ch=str1.charAt(str1.length()-1);
        ans.append(ch);
        ans.append(str1.substring(0, str1.length()-1));
        return ans;
    }
        static StringBuilder checkACLW(StringBuilder str1){
            StringBuilder ans=new StringBuilder();
            char ch=str1.charAt(0);
            ans.append(str1.substring(1, str1.length()));
            ans.append(ch);
            return ans;
        }
    public static void main(String[] args) {
        StringBuilder str1=new StringBuilder("abcde");
        StringBuilder str2=new StringBuilder("cdeab");
        if(checkCLW(checkCLW(str1)).compareTo(str2) == 0){
            System.out.println("Clockwise matched");
        }

        if(checkACLW(checkACLW(str1)).compareTo(str2) == 0){
            System.out.println("Anti-clockwise matched");
        }
    }
}
