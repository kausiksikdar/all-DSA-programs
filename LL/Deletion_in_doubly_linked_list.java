package LL;

public class Deletion_in_doubly_linked_list {
    public static class ListNode{
        int val;
        ListNode next,prev;
        ListNode(int data){
            val=data;
            next=null;
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
        int[] arr = {1, 2, 3, 4, 5};
       ListNode head=createDLL(arr,0, arr.length, null);
        ListNode display=head;
        while (display!=null){
            System.out.print(display.val+" ");
            display=display.next;
        }
        System.out.println();
         //Deletion from start
        if (head!=null){
            //If one node exist
            if (head.next==null){
                head=null;
            }
            //More than one node
            else {
                head=head.next;
                head.prev=null;
            }
        }
        display=head;
        while (display!=null){
            System.out.print(display.val+" ");
            display=display.next;
        }
        System.out.println();

        //Deletion at end
        //if one node exist
        if (head!=null) {
            if (head.next == null) {
                head = null;
            }
            //if more than one node exist
            else {
                ListNode curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.prev.next = null;
            }
        }
        display=head;
        while (display!=null){
            System.out.print(display.val+" ");
            display=display.next;
        }
        System.out.println();

        //Deletion at any random position
        int pos=2;
        if (head!=null){
            if (pos==0){
                //If one node exist
                if (head.next==null){
                    head=null;
                }
                //More than one node
                else {
                    head=head.next;
                    head.prev=null;
                }
            }
            else {
                ListNode crr=head;
                while (pos!=1){
                    crr=crr.next;
                    pos--;
                }
                //Delete at end
                if (crr.next==null){
                    crr.prev.next=null;
                }
                //Delete at middle
                else {
                    crr.prev.next=crr.next;
                    crr.next.prev=crr.prev;
                }
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
