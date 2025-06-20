import java.util.ArrayList;

public class leaders_in_array {
      static ArrayList< Integer > superiorElements(int []a) {
        int compare=Integer.MIN_VALUE;
        int n=a.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(a[i]>compare){
                ans.add(a[i]);
            }
            compare=Math.max(a[i], compare);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2};
        System.out.println(superiorElements(a));
    }
}
