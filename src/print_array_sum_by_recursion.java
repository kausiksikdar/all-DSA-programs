public class print_array_sum_by_recursion {
    static int sum(int[] arr, int i){
       if(i==0) return arr[0];
       return arr[i]+sum(arr,i-1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5}; //15
        System.out.println(sum(arr, arr.length-1));
    }

    public static class print_subsequense_of_array {
    }
}
