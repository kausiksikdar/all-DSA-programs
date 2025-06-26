package Arrays;

import java.util.ArrayList;

public class alternate_positive_negative {
    //This code is valid when both positive and negative may or may not be equal
    static int[] alternateBrute(int[] arr){
        int n=arr.length;
        int posIdx = 0;
        int negIdx = 0;
        ArrayList<Integer> positive=new ArrayList<>();//To count the number of positive elements
        ArrayList<Integer> negative=new ArrayList<>();//To count the number of negative elements
        for (int i=0;i<n;i++){
            if (arr[i]>0){
                positive.add(arr[i]);
            }
            else {
                negative.add(arr[i]);
            }
        }
        int i=0;
       while (i<n){
            if (posIdx<positive.size()) { //If posIdx<positive.size() i.e. positive elements are still remaining the fill it and increment 'i'; if all positive elements are completed then this statement will not run
                arr[i++] = positive.get(posIdx++);
            }
             if (negIdx<negative.size()) { //If negIdx<negative.size() i.e. negative elements are still remaining the fill it and increment 'i'; if all negative elements are completed then this statement will not run
                 arr[i++] = negative.get(negIdx++);
            }

        }
        return arr;
    }
    //This code is valid when both positive and negative elements are equal
    static int[] alternate(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int posIdx = 0;
        int negIdx = 1;
        for (int j : arr) {
            if (j > 0) {
                ans[posIdx] = j;
                posIdx += 2;
            }
            else {
                ans[negIdx] = j;
                negIdx += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, 1, 2, 3};
        int[] ans = alternateBrute(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
