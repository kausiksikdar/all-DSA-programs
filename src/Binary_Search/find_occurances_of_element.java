package Binary_Search;

public class find_occurances_of_element {
    /*Time Complexity = O(n)*/
    static void findOccurences(int[] A){
        int n=A.length;
        for(int i=0;i<n;i++){
            A[i]--;
        }
        for(int i=0;i<n;i++){
            A[A[i]%n]+=n;
        }
        for(int i=0;i<n;i++){
            if(A[i]/n!=0){
                System.out.print(i+1+" "+A[i]/n);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {2,4,3,6,7,4,3,2,7,1};
        findOccurences(A);
    }
}
