import java.util.HashMap;
public class subarray_sum_divisible_by_k {
    static int subarraySumDivisibleByK(int[] arr, int k){
        HashMap<Integer, Integer> m=new HashMap<>();
        m.put(0,1);
        int prefix=0,total=0,rem;
        for (int j:arr){
            prefix+=j;
            rem=prefix%k;
            if (rem<0) rem+=k;
            if (m.containsKey(rem)) total+=m.get(rem);

            if (m.containsKey(rem)) m.put(rem,m.get(rem)+1);
            else m.put(rem,1);
        }
        return total;
    }
    public static void main(String[] args) {
        int[] arr={2,3,-8,-3,11,4,8,6,9,4};
        int k=7;
        System.out.println(subarraySumDivisibleByK(arr,k));
    }
}
