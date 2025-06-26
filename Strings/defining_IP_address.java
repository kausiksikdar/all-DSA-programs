package Strings;

public class defining_IP_address {
    static StringBuilder definingIPAddress(StringBuilder s){
        StringBuilder ans=new StringBuilder();
        int idx=0;
        while (idx<s.length()){
            if(s.charAt(idx)=='.'){
                ans.append("[.]");
            }
            else ans.append(s.charAt(idx));

            idx++;
        }
        return ans;
    }
    public static void main(String[] args) {
        StringBuilder s=new StringBuilder("255.3.0");
        StringBuilder ans=definingIPAddress(s);
        System.out.println(ans);
    }
}
