import java.util.ArrayList;
import java.util.Stack;

public class string_manipulation {
    static void swap(ArrayList<String> answer, int j, int k)
    {
        String temp=answer.get(j);
        answer.set(j,answer.get(k));
        answer.set(k,temp);
    }
    static void reverse(ArrayList<String> answer)
    {
        int j=0,k=answer.size()-1;
        while (k>j)
        {
            swap(answer,j,k);
            j++;
            k--;
        }
    }
    static ArrayList<String> beautifulString(String[] str){
        int n=str.length;
        Stack<String> st=new Stack<>();
        for (int j=0;j<n;j++)
        {
            if (st.empty())
                st.push(str[j]);

            else if (st.peek()==str[j])
                    st.pop();

            else
                st.push(str[j]);
        }
        ArrayList<String> answer=new ArrayList<>();
        while (!st.empty())
        {
            answer.add(st.peek());
            st.pop();
        }

        reverse(answer);

        return answer;
    }
    public static void main(String[] args) {
        String[] str={"ab","bc","da","da","bc","cd"};
        System.out.println(beautifulString(str));
    }
}
