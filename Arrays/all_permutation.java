package Arrays;

import java.util.ArrayList;//I i u

public class all_permutation {
    static ArrayList<StringBuilder> allPermutation(int[] arr, StringBuilder temp, int index, ArrayList<StringBuilder> ans){
        if (index==arr.length){
            ans.add(temp);
            return ans;
        }
        allPermutation(arr,temp,index+1,ans);
        StringBuilder newTemp=new StringBuilder(temp);
        newTemp.append(arr[index]);
        allPermutation(arr,newTemp,index+1,ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        ArrayList<StringBuilder> ans=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        ans=allPermutation(arr,temp,0,ans);
        for (int i=0;i<ans.size();i++){
                System.out.println(ans.get(i));
        }
    }
}
