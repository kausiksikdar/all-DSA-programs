public class sort_LL_by_merge_sort {
    public static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
        }
    }
    static Node createLL(int[] arr, int index, int n){
        if (index==n) return null;
        Node temp=new Node(arr[index]);
        temp.next=createLL(arr,index+1,n);
        return temp;
    }
    static Node midNodeFinder(Node head){
        Node slow=head,fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    static Node merge(Node l1, Node l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.data>l2.data){
            Node temp=l1;
            l1=l2;
            l2=temp;
        }
        Node res=l1;
        while (l1!=null && l2!=null){
            Node temp=null;
            while (l1!=null && l1.data<l2.data){
                temp=l1;
                l1=l1.next;
            }
            temp.next=l2;
            Node tempo=l1;
            l1=l2;
            l2=tempo;
        }
        return res;
    }
    static Node mergeSort(Node head){
        if (head==null || head.next==null) return head;
        //find the middle node
        Node mid=midNodeFinder(head);

        Node head1=mid.next;
        mid.next=null;
        Node left_head=mergeSort(head);
        Node right_head=mergeSort(head1);
        return merge(left_head,right_head);
    }
    public static void main(String[] args) {
        int[] arr={3,2,4,5,1};
        Node head=createLL(arr,0,arr.length);
        head = mergeSort(head);
        while (head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
    }
}
