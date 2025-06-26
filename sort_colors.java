public class sort_colors {
    static void displayArr(int[] arr){
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
    static void swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    //There is 3 iterations to complete the total sorting so TC=O(3n)
    static void sortColors(int[] colors) {
        int n = colors.length;
        int index = 0, pos = 0;
        while (index < 3) {
            for (int i = 0; i < n; i++) {
                if (colors[i] == index) {
                    swap(colors, i, pos);
                    pos++;
                }
            }
            index++;
        }
    }
    //TC=O(n) ; only one iteration is needed to complete the total sorting
    static void dutchNationalFlagAlgorithm(int[] arr){
        int n=arr.length;
        int low=0,mid=0,high=n-1;
        while (mid<=high){
            if (arr[mid]==0){
                swap(arr,mid,low);
                mid++;
                low++;
            }
            else if (arr[mid]==1){
                mid++;
            }
            else {
                swap(arr,mid,high);
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] colors={0,2,2,1,1,0,2,1,0,1,0,2,0,0};
        dutchNationalFlagAlgorithm(colors);
        displayArr(colors);
    }
}
