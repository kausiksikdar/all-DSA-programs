package Arrays;

import java.util.*;
public class arrayIntro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[] arr = new int[n];
        //How to input an array
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        //To print the array
        for (int j : arr) {
            System.out.print(" " + j);
        }
      //LineBreak
        System.out.println();
      //To declare a ArrayList
        ArrayList<Integer> li = new ArrayList<>();
        //Add elements in arraylist
        li.add(20);
        li.add(250);
        //Print the arrayList
        for (Integer p : li) {
            System.out.print(" " + p);
        }
    }
}
