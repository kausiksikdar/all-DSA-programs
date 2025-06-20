package LL;

public class deletion_a_node_in_linked_list {
    public static class Node{
        int data;
       Node next;
        Node(int val){
            data=val;
            next=null;
        }
    }
    static Node CreateLinkedList(int[] arr, int index, int size){
    if (index==size){
        return null;
    }
    Node temp=new Node(arr[index]);
    temp.next=CreateLinkedList(arr,index+1,size);
    return temp;
}
    static Node deleteNode(Node curr, int x){
        if (x==1){
            return curr.next;
        }
        curr.next=deleteNode(curr.next,x-1);
        return curr;
    }

    public static void main(String[] args) {
        Node head=null;
        int[] ArraY ={1,5,4,2,9,8,7};
        //Creation of Linked List
        head=CreateLinkedList(ArraY, 0, ArraY.length);
        //Print
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Deletion of one element from beginning
        if (head!=null){
            head=head.next;
        }
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Deletion of one element from last
        Node curr=head;
        Node prev=null;

        if (head!=null) {
            if (head.next==null){
                head=null;
            }
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            if (prev!=null){
                prev.next = null;
            }
        }
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Deletion of any particular node
         curr=head;
         prev=null;
         int x=3;
         if (x==1){
             head=head.next;
         }
         else {
             x--;
             while (x != 0) {
                 prev = curr;
                 curr = curr.next;
                 x--;
             }
             prev.next = curr.next;
         }
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Deletion of a particular node using recursion
        head=deleteNode(head,2);
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
