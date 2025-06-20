package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class all_permutation_with_repeat_elements {
    static void swap(int[] arr, int j, int k){
        int temp=arr[j];
        arr[j]=arr[k];
        arr[k]=temp;
    }
    static void permut(int[] arr, ArrayList<int[]> ans, int index){
        int[] array=new int[arr.length];
        for (int k=0;k<arr.length;k++){
            array[k]=arr[k];
        }
        if (index==arr.length){
            ans.add(array);
            return;
        }
        boolean[] check=new boolean[21];
        for (int j=index;j<arr.length;j++){
            if (!check[arr[j] + 10]){
               swap(arr,index,j);
                permut(arr,ans,index+1);
               swap(arr,j,index);
            }
            check[array[j]+10]=true;
        }
    }
    public static void main(String[] args) {
        int[] arr={1,1,2};
        ArrayList<int[]> ans=new ArrayList<>();
        permut(arr, ans, 0);
        for (int[] a:ans){
            System.out.println(Arrays.toString(a));
        }
    }
}
