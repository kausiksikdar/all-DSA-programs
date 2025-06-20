package LL;

import java.util.Scanner;

public class insertion_in_a_linked_list {
    //Creation of Node Class
     public static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
            next=null;
        }
    }

    //Create a node and return its address by recursive way (Insert at end)
    //Every time we create a new node and put value in it and at end we return by pouring the address of current to its previous
    //Overall TC=O(n)  SC=O(n)(As recursive stack is used)
    static Node CreateLinkedList(int[] arr, int index, int size){
        if (index==size){
            return null;
        }
        Node temp=new Node(arr[index]);
        temp.next=CreateLinkedList(arr,index+1,size);
        return temp;
    }

    //Create a node and return its address by recursive way (Insert at beginning)
    //Every time we create a new node and put value in it and at end we return the last node address as head
    //Overall TC=O(n)  SC=O(n)(As recursive stack is used)
    static Node CreateLinkedListB(int[] arr, int index, int size, Node prev){
        if (index==size){
            return prev;
        }
        Node temp=new Node(arr[index]);
        temp.next=prev;
        return CreateLinkedListB(arr,index+1,size,temp);
    }

    static Node insertAtIdxX(Node head, int x, Node temp, int val){
        if (x==0){
           Node temp2=new Node(val);
           temp2.next=temp.next;
           temp.next=temp2;
           return head;
        }
        return insertAtIdxX(head,x-1,temp.next,val);
    }
    public static void main(String[] args) {
       int[] arr={2,4,6,8};
        Node head;
       //Insert at beginning(Creation Of LL)
        //Convert the array to linked list
        //TC=O(n)  SC=O(1)
        head=null;
        for (int i=0;i< arr.length;i++){
            if(head==null){
                head=new Node(arr[i]); //Creation of new node and insert it into the linked list
            }
            else { //If linked list already exists then ->
                Node temp;//Creation of new node
                temp=new Node(arr[i]);
                temp.next=head;//Point the next of temp to head
                head=temp;//Now the temp will be our new head
            }
        }
        //Print
        Node temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        //Insert the node at the end of the linked list(Creation Of LL)
        //Convert the array to LL
         head=null;
        for (int i=0;i<arr.length;i++){
            if (head==null){//If LL doesn't exist then create it
                head=new Node(arr[i]);
            }
            else { //If already exist then...
                Node tail=head; //Take a tail ptr pointing to head currently
                while (tail.next!=null){
                    tail=tail.next; //Find the last node
                }
                tail.next=new Node(arr[i]); //Insert the data at the last node
            }
        }

        System.out.println();
        //Print
        temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Another way to insert node at last(Creation Of LL)(A new way in which we don't need to traverse the entire LL to find the current tail like previous)
        head=null;
        Node tail=null; //Creation of a new node named as tail
        for (int i=0;i<arr.length;i++){
            if (head==null){ //If LL doesn't exist then create new head and make tail point to that
                head=new Node(arr[i]);
                tail=head;
            }
            else {
               tail.next=new Node(arr[i]); //Add new node to the next of current tail
               tail=tail.next; //Update the tail to its next
            }
        }
        //Print
        temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Create a linked list in recursive way (Insert at end)
        int[] array ={1,5,4,2,9,8,7};
        head=CreateLinkedList(array, 0,array.length);
        //Print
        temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Create a linked list in recursive way (Insert at beginning)
        int[] Array ={1,5,4,2,9,8,7};
        head=CreateLinkedListB(Array, 0,Array.length,null);
        //Print
        temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Insert after index 'x'
        int x=2; //Insert Position

        //Creation of linked list
        int[] ArraY ={1,5,4,2,9,8,7};
        head=CreateLinkedList(ArraY, 0, ArraY.length);
        temp=head;

        //Point the temp to insert position
        while (x-1!=-1){
            temp=temp.next;
            x--;
        }

        //Create a new node named as temp2
        Node temp2=new Node(30);
        //Point temp2.next to temp.next, now temp and temp2 both point to next node of temp (Made new connection; two nodes point one single node)
        temp2.next=temp.next;
        //Now point temp.next to temp2 (Break old connection and then made new connection with new node)
        temp.next=temp2;
        //Print
        temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        //Same as above problem just by recursive way
        temp= insertAtIdxX(head, 2, head ,54);

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
