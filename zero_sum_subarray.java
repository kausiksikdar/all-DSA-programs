import java.util.HashMap;

public class zero_sum_subarray {
    static int total(int[] arr){
        int prefix=0,total=0;
        HashMap<Integer, Integer> m=new HashMap<>();
        m.put(0,1);
        for (int i : arr) {
            prefix += i;
            if (m.containsKey(prefix)) {
                total += m.get(prefix);
                m.put(prefix, m.get(prefix) + 1);
            }
            else {
                m.put(prefix, 1);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[] arr={0,0,5,5,0,0};
        System.out.println(total(arr));
    }
}
