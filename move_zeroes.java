import java.util.Arrays;

public class move_zeroes {
    static int[] moveZeroes(int[] A){
        int index=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=0) A[index++]=A[i];
        }
        while(index<A.length){
            A[index++]=0;
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A = {0,1,0,3,12};
        int[] B = {0};
        int[] ans = moveZeroes(A);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }
}
