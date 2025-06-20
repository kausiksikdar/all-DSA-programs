public class sort_doubly_LL_merge_sort {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val){
            this.val=val;
        }
    }
    //Creation of LL
    static ListNode createLL(int[] arr, int index, int n, ListNode back){
        if (index==n) return null;
        ListNode temp=new ListNode(arr[index]);
        temp.prev=back;
        temp.next=createLL(arr,index+1,n,temp);
        return temp;
    }
    static ListNode midFinder(ListNode head){
        ListNode slow=head, fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static ListNode merge(ListNode left, ListNode right){
        if (left==null) return right;
        if (right==null) return left;
        if (left.val>right.val){
            ListNode temp=left;
            left=right;
            right=temp;
        }
        ListNode head=left;
        while (left!=null && right!=null){
            ListNode tmp=null;
            while (left!=null && left.val<=right.val){
                tmp=left;
                left=left.next;
            }
            tmp.next=right;
            right.prev=tmp;
            ListNode temp=left;
            left=right;
            right=temp;
        }
        return head;
    }
    static ListNode mergeSort(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode mid=midFinder(head);
        ListNode right=mid.next;
        mid.next.prev=null;
        mid.next=null;
        ListNode left=head;
        left=mergeSort(left);
        right=mergeSort(right);
        return merge(left,right);
    }
    public static void main(String[] args) {
        int[] arr={3,2,4,1,5};
        ListNode head=createLL(arr,0,arr.length,null);
        head=mergeSort(head);
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+"<->");
            temp=temp.next;
        }
    }
}
