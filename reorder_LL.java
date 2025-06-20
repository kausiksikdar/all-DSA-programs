public class reorder_LL {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    static ListNode createLL(int[] arr, int index, int n){
        if (index==n) return null;
        ListNode temp=new ListNode(arr[index]);
        temp.next=createLL(arr,index+1,n);
        return temp;
    }
    static ListNode midFinder(ListNode head){
        ListNode slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    static ListNode reverse(ListNode copyHead2){
        ListNode prev=null,front=null;
        while (copyHead2!=null){
            front=copyHead2.next;
            copyHead2.next=prev;
            prev=copyHead2;
            copyHead2=front;
        }
        return prev;
    }
    static ListNode reorderLL(ListNode head){
        if (head==null) return head;
        ListNode mid=midFinder(head);
        ListNode copyHead1=head;
        ListNode copyHead2=mid.next;
        mid.next=null;
        copyHead2=reverse(copyHead2);
        ListNode temp;
        while (copyHead1!=null && copyHead2!=null){
           temp=copyHead1;
           copyHead1= copyHead1.next;
           temp.next=copyHead2;
           ListNode tmp=copyHead1;
           copyHead1=copyHead2;
           copyHead2=tmp;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        ListNode head=createLL(arr,0,arr.length);
        head=reorderLL(head);
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp= temp.next;
        }
    }
}
