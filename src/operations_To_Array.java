import java.util.ArrayList;

public class operations_To_Array {
    static int[] operationsToArray(int[] nums){
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i<n-1){
                if(nums[i]==nums[i+1]){
                    nums[i]*=2;
                    nums[i+1]=0;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }
        }
        for(int i=0; i<n;i++){
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }
        for(int i=0; i<count; i++){
            list.add(0);
        }
        for (int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] A = {1,2,2,1,1,0};
        int[] ans = operationsToArray(A);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
