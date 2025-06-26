import javax.crypto.NullCipher;
import javax.lang.model.type.NullType;

public class next_permutation {
    static void reverse(int[] arr, int st, int end)
    {
        while(st < end)
        {
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int breakPoint = -1;

        for(int i=n-1;i>=1;i--)
        {
            if(arr[i] > arr[i-1])
            {
                breakPoint = i-1;
                break;
            }
        }

        if(breakPoint != -1)
        {
            for (int i = n - 1; i > breakPoint; i--) {
                if (arr[i] > arr[breakPoint]) {
                    int temp = arr[i];
                    arr[i] = arr[breakPoint];
                    arr[breakPoint] = temp;
                    break;
                }
            }
        }

        reverse(arr,breakPoint+1,n-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for(int i=0;i< nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
