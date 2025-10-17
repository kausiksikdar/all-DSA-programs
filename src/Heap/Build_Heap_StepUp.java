package Heap;

import java.util.Scanner;

public class Build_Heap_StepUp {
    static class createHeapStepUp{
        private int size;
        private final int totalSize;
        private final int[] arr;
        createHeapStepUp(int n)
        {
            totalSize = n;
            size = 0;
            arr = new int[n];
        }

        void insert(int x)
        {
            if(size == totalSize)
            {
                System.out.println("No u can't insert more, Heap Overflow");
                return;
            }

            arr[size] = x;
            int index = size;
            size++;

            while (index > 0 && arr[(index-1)/2] < arr[index])
            {
                int temp = arr[index];
                arr[index] = arr[(index-1)/2];
                arr[(index-1)/2] = temp;

                index = (index-1)/2;
            }
            System.out.println("Element inserted in MaxHeap successfully...");
        }
        void delete()
        {
            if(size == 0)
            {
                System.out.println("uu can't delete as Heap Underflow");
                return;
            }

            System.out.println(arr[0] + " deleted from the MaxHeap Successfully...");
            arr[0] = arr[size-1];
            size--;
            heapify(0);
        }
        void heapify(int index)
        {
            int largest = index;
            int left = 2*index+1;
            int right = 2*index+2;

            if(left < size && arr[left] > arr[index])
                largest = left;
            if(right < size && arr[right] > arr[index])
                largest = right;

            if(largest != index)
            {
                int temp = arr[largest];
                arr[largest] = arr[index];
                arr[index] = temp;

                heapify(largest);
            }
        }
    void top()
    {
        if (size > 0)
        {
            System.out.println(arr[0]);
        }
        else
            System.out.println("Heap Underflow, So no top exists");
    }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Heap is a data structure in which we can fetch data on the basis of their priority");
        System.out.println("Let's Build a MaxHeap in StepUp Method : ");
        System.out.println("Please Enter the Size of the heap -> ");
        int n = sc.nextInt();

        createHeapStepUp heap = new createHeapStepUp(n);
        System.out.println("Please Enter the Elements -> ");
        while(n-->0)
        {
            int x = sc.nextInt();
            heap.insert(x);
        }
        System.out.println("Do u want delete elements -> ");
        System.out.println("If yes, press 2 else anything");
        System.out.println("Let's print the top of the MaxHeap...");
        heap.top();
        int d = sc.nextInt();
        if (d == 2)
        {
            System.out.println("enter number of elements to be deleted -> ");
            int de = sc.nextInt();
            while (de-->0)
            {
                heap.delete();
            }
        }
        else
            System.out.println("You choose to not delete");

        System.out.println("Let's print the top of the MaxHeap...");
        heap.top();
        sc.close();
    }
}
