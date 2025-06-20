package LL;

import java.util.*;

public class clone_a_LL {
    public static class Node {
        int data;
        Node next;
        Node arb;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createLL(int[] arr, int index, int size) {
        if (index == size) return null;
        Node temp = new Node(arr[index]);
        temp.next = createLL(arr, index + 1, size);
        return temp;
    }

    static Node get(Node curr1, Node curr2, Node x) {
        if (x == null) return null;
        //x=address needed to find, curr1=head of original LL, curr2=head of copied LL
        //Increment curr1 until it matched with x and inside the loop simultaneously inc. curr1 and curr2
        while (curr1 != x) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        //After increment curr2 is the desired address that should in 'arb' of copied LL
        return curr2;
    }

    //Overall time complexity=O(n2) as one iteration for traversing the LL and one is for find the 'arb' pointer through again traversing
    //Overall Space Complexity=O(1) as no extra space is required
    static Node cloneBrute(Node head) {
        Node temp = head;
        Node headCopy = new Node(-1);//Dummy node
        Node tailCopy = headCopy;
        //creation of LL without random pointer
        while (temp != null) {
            tailCopy.next = new Node(temp.data);
            tailCopy = tailCopy.next;
            temp = temp.next;
        }
        headCopy = headCopy.next; //Deleting the dummy node
        tailCopy = headCopy;
        temp = head;
        //Assigning the random pointers
        while (temp != null) {
            //"get" function helps to find the arbitrary pointer of tailCopy by the help of head, headCopy and temp.arb
            tailCopy.arb = get(head, headCopy, temp.arb);
            tailCopy = tailCopy.next;
            temp = temp.next;
        }
        return headCopy;
    }

    //Because of using hashmap TC is reduced to O(n) and SC is increased by O(n)
    //Overall TC=O(n), SC=O(n)
    static Node cloneBetter(Node head) {
        Node temp = head;
        Node headCopy = new Node(-1);//Dummy node
        Node tailCopy = headCopy;
        //creation of LL without random pointer
        while (temp != null) {
            tailCopy.next = new Node(temp.data);
            tailCopy = tailCopy.next;
            temp = temp.next;
        }
        headCopy = headCopy.next; //Deleting the dummy node
        tailCopy = headCopy;
        temp = head;
        //Creation of hashmap to store the address of nodes of original LL and corresponding to that TC
        HashMap<Node, Node> m = new HashMap<>();
        //Filling the hashmap
        while (temp != null) {
            m.put(temp, tailCopy);
            temp = temp.next;
            tailCopy = tailCopy.next;
        }
        tailCopy = headCopy;
        temp = head;
        //Assigning the random pointer
        while (temp != null) {
            tailCopy.arb = m.get(temp.arb);
            temp = temp.next;
            tailCopy = tailCopy.next;
        }
        return headCopy;
    }

    //TC=O(n), SC=O(1) as time complexity is as same as previous and no extra space is used so space is optimized
    static Node cloneOptimized(Node head) {
        Node temp = head;
        Node headCopy = new Node(-1);//Dummy node
        Node tailCopy = headCopy;
        //creation of LL without random pointer
        while (temp != null) {
            tailCopy.next = new Node(temp.data);
            tailCopy = tailCopy.next;
            temp = temp.next;
        }
        headCopy = headCopy.next; //Deleting the dummy node
        Node curr1 = head, curr2 = headCopy;
        Node front1, front2;
        //merge cloned list and original list together
        while (curr1 != null) {
            front1 = curr1.next;
            front2 = curr2.next;
            curr1.next = curr2;
            curr2.next = front1;
            curr1 = front1;
            curr2 = front2;
        }
        curr1 = head;
        //Assign random pointer
        while (curr1 != null) {
            curr2 = curr1.next;
            if (curr1.arb != null) {
                curr2.arb = curr1.arb.next;
            }
            curr1 = curr2.next;
        }
        curr1 = head;
        //separate out cloned LL from original one
        while (curr1.next != null) {
            front1 = curr1.next;
            curr1.next = front1.next;
            curr1 = front1;
        }
        return headCopy;
    }

    public static void main(String[] args) {
        //Creation of the desired List
        int[] arr = {1, 2, 3, 4, 5};
        Node head = createLL(arr, 0, arr.length);
        head.arb = head.next.next;
        head.next.next.arb = head.next.next.next.next;
        head.next.arb = head;
        head.next.next.next.next.arb = head.next.arb;
        head.next.next.next.arb = head.next.next;

        Node temp = cloneBrute(head);
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        temp = cloneBetter(head);
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        temp = cloneOptimized(head);
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}