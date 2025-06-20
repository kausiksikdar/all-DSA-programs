package LL;

public class check_palindrome_linked_list {
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
    static boolean checkPalindrome(ListNode head){
        if (head.next==null) return true; //If only node is present i.e. it must be palindrome
        ListNode temp=head;
        //Count the total no. of nodes
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        //Divide the linked list into two equal halves
        count=count/2;
        ListNode curr=head,prev=null;
        while (count!=0){
            prev=curr;
            curr=curr.next;
            count--;
        }
        prev.next=null;
        //Reverse the right half of linked list
        ListNode front;
        while (curr!=null){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        //Check by two ptr
        ListNode head1=head; //head is pointing to first list
        ListNode head2=prev; //Prev is pointing to second list
        while (head1!=null){
            if (head1.val!=head2.val){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2};
        //Creation of linked list
        ListNode head = CreateLinkedList(arr, 0, arr.length);

        //call check palindrome function
        System.out.println(checkPalindrome(head));

        //There is another way that we can store the values of nodes in a vector and by two ptr we traverse and check is it palindrome or not :SC=O(n):
    }
}
