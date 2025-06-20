import java.util.HashMap;

public class subarray_sum_equals_to_k {
    static int subarraySumEqualsToK(int[] arr, int k){
        HashMap<Integer, Integer> m=new HashMap<>();
        m.put(0,1); //initially always fill the map with 0 and cnt of 0 will be 1
        int prefix=0,total=0;
        for (int j:arr){
            prefix+=j;
            //check if the reqd. key contains in map or not if yes then we will increase the total
            if (m.containsKey(prefix-k))  total+=m.get(prefix-k);
            //if prefix already present in the map then increase the val of prefix
            if (m.containsKey(prefix))
                    m.put(prefix,m.get(prefix)+1);
            //Otherwise create the key and initialise with 1
            else
                m.put(prefix,1);
        }
        return total;
    }
    public static void main(String[] args) {
        int[] arr={2,1,7,-4,2,1,3,4,-15,2,-3,6};
        int k=6;
        System.out.println(subarraySumEqualsToK(arr,k));
    }
}
