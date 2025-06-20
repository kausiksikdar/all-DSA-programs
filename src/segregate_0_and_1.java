public class segregate_0_and_1 {
    static void swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    static void segregate(int[] arr){
        int n= arr.length;
        int i=0,j=n-1;
        while (i<=j){
            if(arr[i]==1&&arr[j]==0) {
                swap(arr,i,j);
                i++;
                j--;
            }
             if(arr[i]==0) {
                i++;
            }
            if(arr[j]==1)  {
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={0,1,1,0,1,0,1,0,0,1,1,0,0};
        segregate(arr);
        for (int k=0;k< arr.length;k++){
            System.out.print(arr[k]+" ");;
        }
    }
}
