package Arrays;

public class left_rotate_an_array_by_one_place {
    static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void reverse(int[] arr, int i, int j){
        while (i<j){
            swap(arr,i++,j--);
        }
    }
    static void leftRotateAnother(int[] arr){
        reverse(arr,0,arr.length-1);
        reverse(arr,1,arr.length-1);
    }
    static void leftRotate(int[] arr){
        int n=arr.length;
        int cnt=arr[n-1];
        for (int i=n-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=cnt;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        leftRotateAnother(arr);
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
