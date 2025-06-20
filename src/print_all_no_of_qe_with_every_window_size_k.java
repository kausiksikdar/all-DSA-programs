import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class print_all_no_of_qe_with_every_window_size_k {
    static void answerAdditionToAnswer(Queue<Integer> qe, ArrayList<ArrayList<Integer>> ans){
        ArrayList<Integer> temp=new ArrayList<>();
        while (!qe.isEmpty()){
            temp.add(qe.peek());
            qe.remove();
        }
        int j=0;
        while (j<temp.size()){
            qe.add(temp.get(j));
            j++;
        }
        ans.add(temp);
    }
    //TC=O(n^2), SC=O(n)
    static ArrayList<ArrayList<Integer>> printAllNoOfQeWithEveryWindowSizeK(int[] arr, int k){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        Queue<Integer> qe = new LinkedList<>();
        for (int j=0;j<k-1;j++){
            qe.add(arr[j]);
        }
        for (int j=k-1;j<n;j++){
            qe.add(arr[j]);
            answerAdditionToAnswer(qe,ans);
            qe.remove();
        }
        return ans;
    }
    //The below code has a time complexity of O(nk), SC=O(1)
    static ArrayList<ArrayList<Integer>> printAllNoOfQeWithEveryWindowSizeK2(int[] arr, int k){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int n = arr.length;
        int first=0,second=k-1;
        while (second<n){
             ArrayList<Integer> temp=new ArrayList<>();
            for (int j=first;j<=second;j++){
                temp.add(arr[j]);
            }
            ans.add(temp);
            first++;
            second++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,4,5,3,4,3};
        int k=3;
        ArrayList<ArrayList<Integer>> answer=printAllNoOfQeWithEveryWindowSizeK2(arr,k);
        System.out.println(answer);
    }
}
