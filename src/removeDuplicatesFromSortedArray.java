import javax.crypto.spec.PSource;

public class removeDuplicatesFromSortedArray {
    static int removeDuplicates(int[] nums){
        int c = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[c] = nums[i];
                 c++;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        int[] ques = {1,1,1,1,2};
        int[] ans = new int[ques.length];
        int k = removeDuplicates(ques);
        System.out.println(k);
    }
}
