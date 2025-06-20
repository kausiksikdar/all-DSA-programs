import java.util.ArrayList;
import java.util.List;

public class repeating_linear_search {
    static void extendedLinearSearch(int[] A, int x, int idx){
        int n=A.length;
        if(idx==n) return;
        if(A[idx]==x) System.out.println(idx);
        extendedLinearSearch(A,x,idx+1);
    }
    static ArrayList<Integer> allIndices(int[] A, int x, int idx){
        int n=A.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if(idx==n) return ans;
        if(A[idx]==x) ans.add(idx);
        ArrayList<Integer> smallAns = allIndices(A,x,idx+1);
        ans.addAll(smallAns);
        return ans;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5,2,45,2,4,5,5,6,7,8,2,34,5,7,8,9,0,0,0,8,7,6,5,4,3,1,2,3,4,2,2,2};
        //extendedLinearSearch(A,2,0);
        ArrayList<Integer> answer = allIndices(A,2,0);
        for (Integer i:answer) {
            System.out.println(i);
        }

    }
}
