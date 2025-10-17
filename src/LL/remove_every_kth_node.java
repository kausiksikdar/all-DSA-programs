package LL;

import java.util.Optional;

public class remove_every_kth_node {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            val = data;
            next = null;
        }
    }
    static ListNode CreateLinkedList(int[] arr, int index, int size) {
        if (index == size) {
            return null;
        }
        ListNode temp = new ListNode(arr[index]);
        temp.next = CreateLinkedList(arr, index + 1, size);
        return temp;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        //Creation of linked list
        ListNode head=CreateLinkedList(arr,0,arr.length);
        ListNode temp;

        int k=1;
        int cnt=1;
        //If k==1 i.e. remove every 1st node i.e. delete entire linked list
       if (k==1){
           System.out.println(Optional.ofNullable(null));
       }
       //This is valid for k!=1 as if k==1 prev will not update at all for a single time
      else {
           ListNode curr=head,prev=null;
           while (curr != null) {
               //If cnt==k; set the previous node next to current node next update current to next node and make cnt=1
               if (cnt == k) {
                   prev.next = curr.next;
                   curr = prev.next;
                   cnt = 1;
               }
               //Else update prev and curr to next nodes and increase cnt by 1
               else {
                   prev = curr;
                   curr = curr.next;
                   cnt++;
               }
           }
       }

        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}
