package Arrays;

/*There is an array of Integers having both +ve and -ve values and a target, return true if
there is at least a triplet having sum equal to target else return false */
import java.util.*;
public class Three_Sum {
    static boolean threeSum(int[] arr, int target)
    {
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=0;i<n-2;i++)
        {
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j = i+1, k =n-1;
            while(j < k)
            {
                int currSum = arr[i]+arr[j]+arr[k];
                if(currSum == target)
                    return true;
                else if (currSum > target)
                    k--;
                else
                    j++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,2};
        int target = -2;
        System.out.println(threeSum(arr,target));
    }
}
