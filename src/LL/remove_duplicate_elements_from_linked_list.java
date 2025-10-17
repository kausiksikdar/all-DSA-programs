package LL;

import java.util.ArrayList;

public class remove_duplicate_elements_from_linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int data) {
            val = data;
            next = null;
        }
    }
    static ListNode CreateLinkedList(int[] arr, int index, int size){
        if (index==size){
            return null;
        }
        ListNode temp=new ListNode(arr[index]);
        temp.next=CreateLinkedList(arr,index+1,size);
        return temp;
    }

    public static void main(String[] args) {
        int[] array ={1,1,4,2,2,2,7};
       ListNode head=CreateLinkedList(array, 0,array.length);
       //Method 1
        // Take an arraylist store the unique data of linked list and after that print it to the original linked list
        ArrayList<Integer> unique=new ArrayList<>();
        unique.add(head.val);
        ListNode temp=head.next;
        while (temp!=null) {
            if (temp.val != unique.get(unique.size()-1)) {
                unique.add(temp.val);
            }
            temp = temp.next;
        }
        int pos=0;
        temp=head;
        ListNode prev=null;
        while (pos<unique.size()){
            temp.val=unique.get(pos++);
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();

        //Method 2
        //Without taking extra space perform the required operation within the present list
        head=CreateLinkedList(array,0, array.length);
        if (head==null || head.next==null){
            System.out.print(head);
        }
        ListNode curr=head.next;
        prev=head;
        while (curr!=null){
            if (curr.val==prev.val){
                prev.next=curr.next;
                curr=prev.next;
            }
            else {
                curr=curr.next;
                prev=prev.next;
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
