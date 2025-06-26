public class removeElement {
    static int removeElement(int[] nums, int val){
        int c = 0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=val){
                nums[c] = nums[i];
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3,6,5,8,4,3,3,3,3,3,3};
        int val = 3;
        int k = removeElement(nums, val);
        System.out.println(k);
    }
}
