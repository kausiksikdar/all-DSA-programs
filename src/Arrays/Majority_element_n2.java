package Arrays;

public class Majority_element_n2 {
    //Moore's Voting Algorithm
    static int majorityElement(int[] A){
        int n=A.length;
        int candidate=-1,count=0;
        for(int i=0;i<n;i++){
            if(count==0) {
                count++;
                candidate = A[i];
            }
            else{
                if(candidate==A[i])
                    count++;
                else
                    count--;
            }
        }
        return candidate;
    }
    //There may be case that the chosen candidate may not be the one who got more than n/2 votes
    static int optimizedMajorityElement(int[] A){
        int n=A.length;
        int candidate=-1,count=0;
        for(int i=1;i<n;i++){
            if(count==0) {
                count++;
                candidate = A[i];
            }
            else{
                if(candidate==A[i])
                    count++;
                else
                    count--;
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(A[i]==candidate)
                count++;
        }
        if(count>n/2) return candidate;
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {3,3,4,4,4};
        System.out.println(majorityElement(A));
    }
}
