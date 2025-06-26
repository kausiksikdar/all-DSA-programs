package Sorting;

import java.util.Random;

public class quick_sort {
    /*
    * It is a Divide and Conquer Algo
    * Here we 1st choose a pivot element(1st element of Array)
    * Then place that pivot element at its correct position(pivot index)
    * Make sure(By the help of Partition method) that the elements less than pivot element is in left of pivot index
    and vice versa (Partition Condition)
    * Then by the help of recursion we complete the process by calling for left part of pivot
    and right part of pivot

    * It is not a stable algo as here in partition method we use 'lesser than equal to'

    * Partition takes 'n' time as in 'for' loop 'n' iterations can be done
    and a 'while' loop 'n' iterations can be done but in 'while' there is another 'while'
    but this is cannot contribute any time as we go each element at single time
    So by partition max to max n+n=2n=>n time is needed

    * Best case, Average case => T(n)=2T(n/2)+n
    by the end of solving like merge sor we get TC=O(nlog(n))
    * Worst case => T(n)=T(n-1)+n //already sorted array we get, pivot index at its correct position(idx=0)
      left part is not there and last remaining part is (n-1), for partition 'n' time is needed
      After solving it we get TC=O(n^2) (Example: choose 1st element as pivot and already sorted array is given)

    * Space =>
    Best, Average case = log(n)
    Worst case = n

    * It is an In-place algo

    * In partition optimized (partitionO) we choose a random number that
    lies in between the indices of array and make that pivot element to avoid worst case so that the
    time complexity will be 'nlog(n)' (Average case)

    * Most Library function uses 'Quick Sort' to Sort array(Java)
    */
    static void displayArr(int[] A){
        for(int i:A){
            System.out.print(i+" ");
        }
    }
    static void swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    static int partition(int[] A, int st, int end) {
        //Choose the 1st element(i.e. 'st') of array as pivot
        int pivot = A[st];
        //Take a counter variable which counts the no. of elements less than pivot
        int count = 0;
        //By loop get the total no. of elements less than pivot element
        for (int i = st + 1; i <= end; i++) {
            if (A[i] <= pivot) count++;
        }
        //Set pivot index at its correct position
        int pi = st + count;
        //After setting swap the 'st' and 'pivot index'
        swap(A, st, pi);
        //Take two pointers such that they ensure the elements left of 'pi' is smaller and vice versa
        int i = st, j = end;
        while (i < pi && j > pi) {
            //Skipping those elements which are already meet the above condition
            while (A[i] <= pivot) i++;
            while (A[j] > pivot) j--;
            //There is a chance that after entering the main 'while' loop because of the in-between
            // 'while' loops the condition of main loop may be break, so after checking the main condition
            // again by this 'if' condition we finally swap the element to reach the condition
            if (i < pi && j > pi) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return pi;
    }
    static int partitionO(int[] A, int st, int end) {
        Random r = new Random();
        //r.nextInt(upper-lower)+lower
        //Choose any random element of array as pivot
        int random=r.nextInt((end)-(st))+(st+1);
        int pivot = A[random];
        //Take a counter variable which counts the no. of elements less than pivot
        int count = 0;
        //By loop get the total no. of elements less than pivot element
        for (int i = st; i <random; i++) {
            if (A[i] <= pivot) count++;
        }
        for (int i = random+1; i <=end; i++) {
            if (A[i] <= pivot) count++;
        }
        //Set pivot index at its correct position
        int pi = st + count;
        //After setting swap the 'st' and 'pivot index'
        swap(A, random, pi);
        //Take two pointers such that they ensure the elements left of 'pi' is smaller and vice versa
        int i = st, j = end;
        while (i < pi && j > pi) {
            //Skipping those elements which are already meet the above condition
            while (A[i] <= pivot) i++;
            while (A[j] > pivot) j--;
            //There is a chance that after entering the main 'while' loop because of the in-between
            // 'while' loops the condition of main loop may be break, so after checking the main condition
            // again by this 'if' condition we finally swap the element to reach the condition
            if (i < pi && j > pi) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return pi;
    }
    static int partitionBetter(int[] A, int st, int end) {
        //Choose the last element(i.e. 'end') of array as pivot
        int pivot = A[end];
        //Take a counter variable which counts the no. of elements less than pivot
        //Initially that is '-1' => No element is lesser...
        int count = st-1;
        //By loop get the total no. of elements less than pivot element(counting) as well as
        //swapping done by this loop => TC reduces to O(n) from O(2n)
        for (int i = st; i <= end-1; i++) {
            if (A[i] <= pivot)
            {
                count++;
                swap(A,i,count);
            }
        }
        //Set pivot index at its correct position
        int pi = count + 1;
        //After setting swap the 'st' and 'pivot index'
        swap(A, end, pi);
        return pi;
    }
    static void quickSort(int[] A, int st, int end){
        if(st>=end) return; //If there is one element in the array there in no need to sort
        int pi=partitionO(A,st,end);//It is a method by which we mainly return the correct index
        // of pivot as well as make sure the partition condition
        quickSort(A,st,pi-1);//Call Quick Sort in the left half of Array
        quickSort(A,pi+1,end);//Call Quick Sort in the right half of Array
    }
    public static void main(String[] args) {
        int[] A={9,8,7,6,5,4,3,2,1,0};
        System.out.println("Array before sorting ->");
        displayArr(A);
        System.out.println();
        quickSort(A,0,A.length-1);
        System.out.println("Array after sorting ->");
        displayArr(A);
    }
}