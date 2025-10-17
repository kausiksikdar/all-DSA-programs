package Heap;

public class Build_Heap_StepDown {
    static void BuildMaxHeap(int[] arr, int n)
    {
        for(int i=(n-1)/2;i>=0;i--)
            heapify(arr,i,n);
    }
    static void heapify(int[] arr, int index, int n)
    {
        int largest = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if (left < n && arr[left] > arr[index])
            largest = left;
        if (right < n && arr[right] > arr[index])
            largest = right;

        if (largest != index)
        {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            heapify(arr,largest,n);
        }
    }
    public static void main(String[] args) {
         int[] arr = {1,4,2,5,3,9,0};
         int n = arr.length;
         BuildMaxHeap(arr,n);

         for (int i=0;i<n;i++)
             System.out.print(arr[i]+" ");
    }
}
