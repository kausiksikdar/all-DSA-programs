public class write_correctly {
    static StringBuilder writeCorrectly(StringBuilder s){
        int n=s.length();
        StringBuilder[] ans=new StringBuilder[10];
        StringBuilder temp= new StringBuilder();
        int count=0,index=0;

        while (index<n){
            if (s.charAt(index)==' '){
                int pos=temp.charAt(temp.length()-1)-'0';//Find out the correct position
                temp.deleteCharAt(temp.length()-1);//Delete that position denoting char from the string
                ans[--pos]=new StringBuilder(temp); //first dec. the pos by 1 so that it can adjust with the default array indexing
                temp.delete(0,temp.length());//Clear the whole temp
                count++;//Inc. count by 1
            }
            else{
                temp.append(s.charAt(index));//If the current char is not a space just append it in temp
            }
            index++;//Inc. index by 1
        }

        //At last again do the same operation so that last word should be joined as in last there is no space at all
        int pos=temp.charAt(temp.length()-1)-'0';//Find out the correct position
        temp.deleteCharAt(temp.length()-1);//Delete that position denoting char from the string
        ans[--pos]=new StringBuilder(temp);//first dec. the pos by 1 so that it can adjust with the default array indexing
        temp.delete(0,temp.length());//Clear the whole temp
        count++;//Inc. count by 1

        //Now iterate over 'ans' array to finally append the answer with spaces
        for (int i=0;i<count;i++){
            temp.append(ans[i]);
            temp.append(' ');
        }
        //An extra space will be there so just delete it
        temp.deleteCharAt(temp.length()-1);
        return temp;
    }
    public static void main(String[] args) {
        StringBuilder s=new StringBuilder("is2 a3 sentence4 This1");
        StringBuilder ans=writeCorrectly(s);
        System.out.println(ans);
    }
}
