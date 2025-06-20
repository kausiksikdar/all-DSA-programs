package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class bucket_Sort {
    /*
    * It is a non-comparison way of sorting
    * Put all elements in 'b' no of buckets
    * Sort each bucket(Any way of sorting)
    * After-that join them and watch

    * When there is uniform distribution of elements in each bucket, this way is very useful

    * There is no hard and fast rule, it is mainly used in above suitable condition and given input set
       We can choose buckets by any random rule or pattern

    * For example: Sort an Array having numbers in range {0.0, 1.0} with uniform distribution
    Find efficient way of sorting
     {0.32, 0.62, 0.69, 0.15, 0.85, 0.78, 0.17, 0.41, 0.56, 0.97} (total = 10 elements)
    *
     */
    static void displayArr(float[] A){
        for(float i:A){
            System.out.print(i+" ");
        }
    }
    static void bucketSort(float[] A) {
        int n = A.length;
        //Here we are making an Array of Arraylist<Float> named 'buckets'
        ArrayList<Float>[] buckets = new ArrayList[n];
        //Create empty Arraylist
        for(int i=0;i<n;i++){
            buckets[i]=new ArrayList<Float>();
        }
        //Add elements into our buckets
        for(int i=0;i<n;i++){
            int bucketIdx=(int) A[i]*n; //As all the elements lies between 0=>1 first multiply it by total length(10) and then make it an integer
            buckets[bucketIdx].add(A[i]);//Then put that into the respective buckets according to their integer value
        }
        //Sort each bucket individually
        for(int i=0;i< buckets.length;i++){
            Collections.sort(buckets[i]);
        }
        //Join all the buckets to get the final answer
        int index=0; //Traverse the original array to override the answer
        for(int i=0;i< buckets.length;i++){ //traverse all the buckets
            ArrayList<Float> currBucket=buckets[i]; //Take all elements of buckets[i] into an arraylist
            for(int j=0;j<currBucket.size();j++){ //Traverse that arraylist
                A[index++]=currBucket.get(j); //At the time of traversing override all elements to original array
            }
        }
    }
    public static void main(String[] args) {
        float[] A={0.32F, 0.62F, 0.69F, 0.15F, 0.85F, 0.78F, 0.17F, 0.41F, 0.56F, 0.97F};
        System.out.println("Array before sorting =>");
        displayArr(A);
        System.out.println();
        bucketSort(A);
        System.out.println("Array after sorting =>");
        displayArr(A);
    }
}
