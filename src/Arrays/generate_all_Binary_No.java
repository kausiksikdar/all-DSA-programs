package Arrays;

import java.util.ArrayList;
import java.util.List;

public class generate_all_Binary_No {
    static boolean check(String s){
        for (int j=0;j<s.length()-1;j++){
            if (s.charAt(j)=='1' && s.charAt(j+1)=='1'){
                return false;
            }
        }
        return true;
    }
    static ArrayList<String> generateAllBinaryNo(int N, int index, String ans, ArrayList<String> answer){
        if (index==N){
            if (check(ans)){
                answer.add(ans);
            }
            return answer;
        }
        generateAllBinaryNo(N,index+1,ans + '0',answer);
        generateAllBinaryNo(N,index+1, ans + '1',answer);
        return answer;
    }
    public static void main(String[] args) {
        int N=4;
        System.out.println(generateAllBinaryNo(N,0,"", new ArrayList<>()));
    }
}
