public class merge_two_sorted_list {
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
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 5, 8, 9, 10, 154};
        ListNode head1 = CreateLinkedList(arr1, 0, arr1.length);
        ListNode head2 = CreateLinkedList(arr2, 0, arr2.length);
        //here we create an extra node as we need tail.next bt initially if we do not create any node head=null so tail.next will point to non-accessible memory location
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        head = head.next;

        //Print
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
