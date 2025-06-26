package LL;

public class add_two_LL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    static Node createLL(int[] arr, int index, int size){
        if (index==size) return null;
        Node temp = new Node(arr[index]);
        temp.next=createLL(arr,index+1,size);
        return temp;
    }
    static Node reverse(Node curr, Node prev){
        if (curr==null) return prev;
        Node front=curr.next;
        curr.next=prev;
        return reverse(front,curr);
    }
    public static void main(String[] args) {
        int[] arr1={2,4,9};
        int[] arr2={5,6,4,9};
        Node head1=createLL(arr1,0,arr1.length);
        Node head2=createLL(arr2,0,arr2.length);
        head1=reverse(head1,null);
        head2=reverse(head2,null);
        Node curr1=head1;
        Node curr2=head2;
        int carry=0;
        Node head=new Node(-1);
        Node tail=head;
        while (curr1!=null && curr2!=null){
            int sum=curr1.data+curr2.data+carry;
            tail.next=new Node(sum%10);
            tail= tail.next;
            curr1=curr1.next;
            curr2=curr2.next;
            carry=sum/10;
        }
        while (curr1!=null){
            int sum=curr1.data+carry;
            tail.next=new Node(sum%10);
            tail= tail.next;
            curr1=curr1.next;
            carry=sum/10;
        }
        while (curr2!=null){
            int sum=curr2.data+carry;
            tail.next=new Node(sum%10);
            tail= tail.next;
            curr2=curr2.next;
            carry=sum/10;
        }
        while (carry!=0){
            tail.next=new Node(carry%10);
            tail= tail.next;
            carry/=10;
        }
        head= head.next;
        head=reverse(head,null);
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
