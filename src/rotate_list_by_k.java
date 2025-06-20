public class rotate_list_by_k {
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
    static ListNode rotateList(ListNode head, int k){
        if (head==null || head.next==null){
            return head;
        }
        //Count total number of nodes or length of list
        int cnt=0;
        ListNode temp=head;
        while (temp!=null){
            cnt++;
            temp=temp.next;
        }
        //Set k as per requirement
        k=k%cnt;
        //If k==0 i.e. we do not need to rotate list at all just return head we must write its code separately because otherwise the code will give an error as k is not following 0 based indexing
        if (k==0){
            return head;
        }
        //Set cnt such that for performing the operation we just go to the node up to cnt
        cnt-=k;
        ListNode curr=head,prev=null;
        while (cnt!=0){
            prev=curr;
            curr=curr.next;
            cnt--;
        }
        prev.next=null;
        ListNode tail=curr;
        while (tail.next!=null){
            tail=tail.next;
        }
        tail.next=head;
        head=curr;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Creation of linked list
        ListNode head = CreateLinkedList(arr, 0, arr.length);
        ListNode temp;

        int k=3;
        head=rotateList(head,k);

        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        /*There is another way that you just store the data of each node in a vector and then set
        it accordingly back to nodes as per rotation by we expect you actually rotate the nodes
        not just change the data*/
    }
}
