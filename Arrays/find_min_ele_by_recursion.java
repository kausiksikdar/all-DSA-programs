package Arrays;

public class find_min_ele_by_recursion {
    static int minEle(int[] arr, int i){
        if(i==0) return arr[0];
        return Math.min(arr[i],minEle(arr,i-1));
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,-9,0,-7};
        System.out.println(minEle(arr,arr.length-1));
    }
}
