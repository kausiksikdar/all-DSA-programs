package LL;

public class delete_nth_node_from_last {
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

        int n=10;
        //First count total number of nodes
        int count=0;
        temp=head;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        count-=n;
        if (count==0){
            head=head.next;
        }
        else {
            ListNode curr=head,prev=null;
            while (count != 0){
                prev=curr;
                curr=curr.next;
                count--;
            }
            prev.next=curr.next;
        }
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}
