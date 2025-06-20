package Stacks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class first_negative_element_in_every_window_of_size_k {
    static void answerAddition(Queue<Integer> q, ArrayList<Integer> ans){
        boolean flag=false;
        Queue<Integer> q2=new LinkedList<>();
        while (!q.isEmpty()){
            q2.add(q.peek());
            if (!flag && q.peek()<0) {
                ans.add(q.peek());
                flag=true;
            }
            q.remove();
        }
        if (!flag) ans.add(0);
        while (!q2.isEmpty()){
            q.add(q2.peek());
            q2.remove();
        }
    }
    //TC=O(nk) SC=O(k)
    static ArrayList<Integer> negativeBrt(int[] arr, int k){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for (int j=0;j<k-1;j++){
            q.add(arr[j]);
        }
        for (int j=k-1;j<n;j++){
            q.add(arr[j]);
            answerAddition(q,ans);
            q.remove();
        }
        return ans;
    }
    //TC=O(n)
    static ArrayList<Integer> negativeOpt(int[] arr, int k){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for (int j=0;j<k-1;j++){
            if (arr[j]<0) q.add(j);
        }
        for (int j=k-1;j<n;j++){
            if (arr[j]<0) q.add(j);
            if (q.isEmpty()) ans.add(0);
           else {
            if (q.peek()<=j-k) q.remove();
            if (q.isEmpty()) ans.add(0);
            else ans.add(arr[q.peek()]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={2,-3,-4,-2,7,8,9,-10};
        int k=3;
        System.out.println(negativeBrt(arr,k));
        System.out.println(negativeOpt(arr,k));
    }
}
