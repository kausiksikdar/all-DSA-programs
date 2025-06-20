import java.util.ArrayList;

public class pascal_triangle {
    static int fact(int k){
        int fact=1;
        for(int i=1;i<=k;i++){
            fact*=i;
        }
        return fact;
    }
    static int comb(int i, int j){
        return fact(i)/(fact(j)*fact(i-j));
    }
    //Approx time complexity=O(n^3)
    static ArrayList<ArrayList<Integer>> pascalTriangleBrute(int n){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> smallAns=new ArrayList<>();
            for(int j=0;j<=i;j++){
                smallAns.add(comb(i,j));
            }
            ans.add(smallAns);
        }
        return ans;
    }
    // Function to generate every row of Pascal Triangle
    static  ArrayList<Integer> pascalTriangleOneRow(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        int answer=1;
        ans.add(answer); //We 1st add '1' to the ans and after that we add the answers taking reference of that answer
        for(int col=1;col<n;col++){
            answer*= n - col;
            answer/=col;
            ans.add(answer);
        }
        return ans;
    }
    //Approx time complexity=O(n^2)
    static ArrayList<ArrayList<Integer>> pascalTriangle(int n){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for (int i=1;i<=n;i++){ //Row is following one-based indexing
            ans.add(pascalTriangleOneRow(i)); //For every row we are calling generate-row function
        }
        return ans;
    }
    public static void main(String[] args) {
        int numOfRows=5;
        ArrayList<ArrayList<Integer>> ans=pascalTriangle(numOfRows);
        System.out.println(ans);
    }
}
