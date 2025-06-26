package LL;

public class Insertion_in_doubly_linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int data) {
            val = data;
            next = null;
            prev=null;
        }
    }
    static ListNode createDLL(int[] arr, int index, int size, ListNode back){
        if (index== arr.length) return null;
        ListNode temp=new ListNode(arr[index]);
        temp.prev=back;
        temp.next=createDLL(arr,index+1,size,temp);
        return temp;
    }
    public static void main(String[] args) {
        //Insertion node at beginning
        ListNode head = null;
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new ListNode(arr[i]);
            } else {
                ListNode temp = new ListNode(arr[i]);
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }
        ListNode display=head;
        while (display!=null){
            System.out.print(display.val+" ");
            display=display.next;
        }
        System.out.println();

        //Insertion node at end
        head=null;
        ListNode tail=null;
        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new ListNode(arr[i]);
                tail = head;
            }
            //Here we cannot use this below process because this is used for singly linked list
//            else {
//                ListNode curr=head;
//                while (curr.next!=null){
//                    curr=curr.next;
//                }
//                ListNode temp=new ListNode(arr[i]);
//                curr.next=temp;
//                temp.prev=curr;
//            }
            else {
                ListNode temp=new ListNode(arr[i]);
                tail.next=temp;
                temp.prev=tail;
                tail=temp;
            }
        }
        display=head;
        while (display!=null){
            System.out.print(display.val+" ");
            display=display.next;
        }
        System.out.println();

        //Creation of Linked List
        head=createDLL(arr,0, arr.length, null);
        display=head;
        while (display!=null){
            System.out.print(display.val+" ");
            display=display.next;
        }
        System.out.println();

        //Insertion at any random position
        int pos=3;

        if (pos==0){ //Insert at first
            //If Linked List doesn't exist
            if (head==null){
                head=new ListNode(7);
            }
            //LL already exist
            else {
               ListNode temp=new ListNode(7);
               temp.next=head;
               head.prev=temp;
               head=temp;
            }
        }
        else {
            ListNode curr=head;
            //Go to the node
            while (pos!=1){
                curr=curr.next;
                pos--;
            }
            //If we need to insert at last
            if (curr.next==null){
                ListNode temp=new ListNode(7);
                temp.prev=curr;
                curr.next=temp;
            }
            //Insert at any random position
            else {
                ListNode temp=new ListNode(7);
                temp.next=curr.next;
                temp.prev=curr;
                curr.next=temp;
                temp.next.prev=temp;
            }
        }
        display=head;
        while (display!=null){
            System.out.print(display.val+" ");
            display=display.next;
        }
        System.out.println();
    }
}
