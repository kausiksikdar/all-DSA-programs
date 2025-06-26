package LL;

public class reorder_doubly_LL {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val){
            this.val=val;
        }
    }
    static ListNode createLL(int[] arr, int index, int n, ListNode back){
        if (index==n) return null;
        ListNode temp=new ListNode(arr[index]);
         temp.prev=back;
         temp.next=createLL(arr,index+1,n,temp);
         return temp;
    }
    static ListNode tailFinder(ListNode head){
        ListNode tail=head;
        while (tail.next!=null){
            tail=tail.next;
        }
        return tail;
    }
    static ListNode reorder(ListNode head){
        ListNode tail=tailFinder(head);
        ListNode copyHead=head;
        ListNode temp,temp2;
        while (copyHead!=tail){
            temp=copyHead;
            copyHead=copyHead.next;
            temp2=tail;
            tail=tail.prev;
            temp.next=temp2;
            temp2.prev=temp;
            temp2.next=copyHead;
            copyHead.prev=temp2;
        }
        copyHead.next=null;
        return head;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        ListNode head=createLL(arr,0,arr.length,null);
        head=reorder(head);
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+"<->");
            temp=temp.next;
        }
    }
}
