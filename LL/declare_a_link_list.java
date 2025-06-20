package LL;

public class declare_a_link_list {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static void displayr(Node head){
        if(head==null) return;
        System.out.print(head.data+" ");
        displayr(head.next);
    }
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(7);
        Node d = new Node(10);
        Node e = new Node(15);

        System.out.println();
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        Node temp = a;

        for (int i=1;i<=5;i++){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();
        temp=a;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();

        displayr(a);
    }
}
