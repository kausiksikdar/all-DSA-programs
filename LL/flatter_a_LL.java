package LL;

public class flatter_a_LL {
    public static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createLL(int[] arr, int index, int size) {
        if (index == size) return null;
        Node temp = new Node(arr[index]);
        temp.bottom = createLL(arr, index + 1, size);
        return temp;
    }

    static Node merge(Node head1, Node head2) {
        Node head = new Node(-1);//Dummy node
        Node tail = head;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.bottom = head1;
                head1 = head1.bottom;
                tail = tail.bottom;
            } else {
                tail.bottom = head2;
                head2 = head2.bottom;
                tail = tail.bottom;
            }
        }
        if (head1 != null) tail.bottom = head1;
        else tail.bottom = head2;
        return head.bottom;
    }

    static void mergeToSingleLL(Node root) {
        Node head1, head2, head3;
        while (root.next != null) {
            //Store the root, the next of root and the next of root.next in three pointers
            head1 = root;
            head2 = root.next;
            head3 = root.next.next;
            //Detach the first LL with the rest
            head1.next = null;
            //Detach the second LL with the rest
            head2.next = null;
            //Merge that two LL separately and store it in the root
            root = merge(head1, head2);
            //Finally assign root.next to head3 pointer
            root.next = head3;
        }
    }

    public static void main(String[] args) {
        //creation of flatter LL
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 5, 6};
        int[] arr3 = {3, 4, 5};
        int[] arr4 = {5, 8, 9};
        Node head1 = createLL(arr1, 0, arr1.length);
        Node head2 = createLL(arr2, 0, arr2.length);
        Node head3 = createLL(arr3, 0, arr3.length);
        Node head4 = createLL(arr4, 0, arr4.length);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        //Call the mergeToSingleLL function
        mergeToSingleLL(head1);

        //Print
        Node temp = head1;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
    }
}
