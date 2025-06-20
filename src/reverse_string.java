public class reverse_string {
    static StringBuilder reverseString(StringBuilder s){
        StringBuilder[] ans=new StringBuilder[10000];
        StringBuilder temp=new StringBuilder();
        int count=0,index=0,pos=0;
        while (index<s.length()){
            if(s.charAt(index)==' '){
                ans[pos]=new StringBuilder(temp);
                pos++;
                temp.delete(0,temp.length());
                count++;
            }
            else {
                temp.append(s.charAt(index));
            }
            index++;
        }
        ans[pos]=new StringBuilder(temp);
        temp.delete(0,temp.length());
        count++;
        for (int i=count-1;i>=0;i--){
            if(ans[i].isEmpty()) continue;
            temp.append(ans[i]);
            temp.append(' ');
        }
        temp.deleteCharAt(temp.length()-1);

        return temp;
    }
    public static void main(String[] args) {
        StringBuilder s=new StringBuilder("                                                the                              sky          is blue                                                        ");
        StringBuilder ans=reverseString(s);
        System.out.println(ans);
    }
}
