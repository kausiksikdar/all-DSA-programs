package LL;

public class middle_of_a_linked_list {
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
    static void findMiddle(ListNode head){
        ListNode slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println("The middle of List is : "+slow.val);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        //Creation of linked list
        ListNode head=CreateLinkedList(arr,0,arr.length);
        ListNode temp;
        //First count the number of nodes in the linked list
        int cnt=0;
        temp=head;
        while (temp!=null){
            cnt++;
            temp=temp.next;
        }
        //At half of cnt i.e. there must be middle
        cnt=cnt/2;
        temp=head;
        while (cnt!=0){
            temp=temp.next;
            cnt--;
        }
        System.out.println("The middle node is : "+temp.val);

        //Can we avoid two time traversal
        //Optimized way i.e. concept of slow and fast pointer
        findMiddle(head);
    }
}
