public class reverse_entire_node_of_linked_list {
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
    static ListNode reverseList(ListNode curr, ListNode prev){
        if (curr==null){
            return prev;
        }
        ListNode fut=curr.next;
        curr.next=prev;
        return reverseList(fut,curr);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = CreateLinkedList(arr, 0, arr.length);
        System.out.print("Creation Of Linked List : ");
        //Print
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        //Reverse by while loop
        ListNode curr = head, prev = null, fut = null;
        while (curr != null) {
            fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }
        head = prev;
        System.out.print("Reverse List : ");
        //Print
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        //Reverse by Recursion
        head=reverseList(head,null);
        System.out.print("Reverse List : ");
        //Print
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
