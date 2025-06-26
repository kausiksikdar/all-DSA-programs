package Binary_Search;

public class find_second_largest_element {
    static int findSecondLargestElement(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE,idx=-1,secondMax=Integer.MIN_VALUE,secondIdx=-1;
        for (int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                idx=i;
            }
        }
        for (int i=0;i<n;i++){
            if(arr[i]>secondMax && i!=idx){
                secondMax=arr[i];
                secondIdx=i;
            }
        }
        return secondIdx;
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,7,34,56,71};
        System.out.println(findSecondLargestElement(arr));
    }
}
