import javax.crypto.NullCipher;
import javax.lang.model.type.NullType;

public class next_permutation {
    static void nextPermutation(int[] nums){
        if(nums.length<=1) System.out.println(nums[0]);
        int i = nums.length-2;
        while (i>=0 && nums[i]>nums[i+1]) i--;
        int j = nums.length-1;
        while (i>=0 && nums[i]>nums[j]) j--;
        swap(nums,i,j);
        reverse(nums, i+1,nums.length-1);
    }
    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    static void reverse(int[] nums, int i, int j){
        while (i<j) swap(nums, i++, j--);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for(int i=0;i< nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
