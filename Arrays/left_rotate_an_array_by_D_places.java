package Arrays;

public class left_rotate_an_array_by_D_places {
    static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void reverse(int[] arr, int i, int j){
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
    static void leftRotate(int[] arr, int k){
        int n= arr.length;
        k=k%n;
        reverse(arr,0, n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int k=99;
        leftRotate(arr,k);
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
