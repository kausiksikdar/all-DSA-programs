import java.util.ArrayList;

public class n_bit_binary_no {
   static ArrayList<StringBuilder> ans(int n, ArrayList<StringBuilder> answer, StringBuilder temp, int zero, int one)
   {
       if (temp.length()==n)
       {
           answer.add(temp);
           return answer;
       }
       if (zero<one)
       {
        StringBuilder tempo=new StringBuilder(temp);
        tempo.append('0');
        ans(n,answer,tempo,zero+1,one);
       }

       temp.append('1');
       ans(n, answer, temp, zero, one + 1);

        return answer;
   }
    public static void main(String[] args) {
        int n=3;
        System.out.println(ans(n,new ArrayList<>(),new StringBuilder(),0,0));
    }
}
