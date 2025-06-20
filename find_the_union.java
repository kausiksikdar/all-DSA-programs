import java.util.ArrayList;

public class find_the_union {
    static ArrayList<Integer> sortedArray(int[] a, int[] b){
        ArrayList<Integer> ans=new ArrayList<>();
        int m=a.length;
        int n=b.length;
        int first=0,second=0;
        ans.add(0);//Pseudo-element added to meet the cond. of ans.get(ans.size()-1) Otherwise runtime error occurs
        while (first<m && second<n){
            if(a[first]<b[second]){
        if (ans.get(ans.size()-1)!=a[first]){
            ans.add(a[first]);
        }
                first++;
            }
            else if (a[first]==b[second]){
                if (ans.get(ans.size()-1)!=a[first]){
                    ans.add(a[first]);
                }
                first++;
                second++;
            }
            else {
                if (ans.get(ans.size()-1)!=b[second]){
                    ans.add(b[second]);
                }
                second++;
            }
        }
        while (first<m) {
            if (ans.get(ans.size()-1)!=a[first]){
                ans.add(a[first]);
            }
            first++;
        }
        while (second<n){
            if (ans.get(ans.size()-1)!=b[second]){
                ans.add(b[second]);
            }
            second++;
        }
        ans.remove(0); //Remove the pseudo-element from 0th index before return the final answer
        return ans;
    }
    public static void main(String[] args) {
        int[] a={1,2,4,6};
        int[] b={2,3,4};
        System.out.println(sortedArray(a,b));
    }
}
