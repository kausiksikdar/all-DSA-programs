package LL;

public class circular_linked_list {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    static Node createLL(int[] arr, int index, int size){
        if (index==size) return null;
        Node temp=new Node(arr[index]);
        temp.next=createLL(arr,index+1,size);
        return temp;
    }
    public static void main(String[] args) {
        int[] arr={4,5,2,1,0,3,6,9,8,7,1,3,0,4,8,6,2,2,8};
        Node head=createLL(arr,0,arr.length);
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node tail=temp;
        tail.next=head;

        temp=head;
        int rotation=0;
        while (temp!=null){
            if (temp==head.next) rotation++;
            if (rotation>1) break;
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
