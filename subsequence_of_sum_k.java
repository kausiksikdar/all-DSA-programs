import java.util.*;

public class subsequence_of_sum_k {
    static void subsequenceOfSumK(int[] arr, int s,int k, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans, int index){
        if (s==k) {
            ans.add(temp);
            return;
        }
        if (index==arr.length || s>k) {
            return;
        }
        int x=s;
        ArrayList<Integer> tempo=new ArrayList<>(temp);
        x+=arr[index];
        tempo.add(arr[index]);
        subsequenceOfSumK(arr,x,k,tempo,ans,index+1);

        subsequenceOfSumK(arr,s,k,temp,ans,index+1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,1};
        int k=2;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        subsequenceOfSumK(arr,0,k,new ArrayList<>(),ans,0);
        System.out.println(ans);
    }
}
