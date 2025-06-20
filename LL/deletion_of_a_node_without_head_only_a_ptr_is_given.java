package LL;

public class deletion_of_a_node_without_head_only_a_ptr_is_given {

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

        //Deletion of any particular element without any help of head ptr
        Node curr=null;
       if (head!=null) {
            curr = head.next.next.next;//Delete 4th node
       }
       if (curr!=null) {
           temp = curr.next;//Store the address of next node of current ptr to a variable named temp
           curr.data=temp.data;//Override the current ptr data with its next i.e. temp ptr data
           curr.next=temp.next;//update the curr.next ptr with temp.next
       }
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
