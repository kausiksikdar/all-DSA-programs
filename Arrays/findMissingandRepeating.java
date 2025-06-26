package Arrays;

import java.util.Collection;

public class findMissingandRepeating{
    static int[] ans(int[] arr, int n){
        int[] temp  = new int[n]; // Creating temp array of size n
        // with initial values as 0.
        int repeatingNumber = -1;
        int missingNumber = -1;
        int[] ans = {missingNumber,repeatingNumber};
        for (int i = 0; i < n; i++) {
            temp[arr[i] - 1]++;//Updating the values of temp array
            if (temp[arr[i] - 1] > 1) {
                ans[0] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] == 0) {
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }
    static int[] optimizedWay(int[] A, int n){
        int[] ans=new int[2];
        for(int i=0;i<n;i++)
            A[i]--;
        for(int i=0;i<n;i++)
            A[A[i]%n]+=n;
        for(int i=0;i<n;i++){
            if(A[i]/n==0) ans[1]=i+1;
            if(A[i]/n>1) ans[0]=i+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A={2,4,6,3,1,6};
        int[] answer=optimizedWay(A,A.length);
        for(int i:answer){
            System.out.print(i+" ");
        }
    }
}