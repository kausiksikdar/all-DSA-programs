package LL;

public class reverse_a_LL_group_of_elements {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    static node createLL(int[] arr, int index, int size){
        if (index==size) return null;
        node temp=new node(arr[index]);
        temp.next=createLL(arr,index+1,size);
        return temp;
    }

    public static void main(String[] args) {
        int[] arr={24,56,2,3,4,56,78,90,45,32};
        int k=4;
        node head=createLL(arr,0,arr.length);
        node first=new node(-1);
        first.next=head;
        head=first;
        while (first.next!=null){
            int x=k;
            node second=first.next;
            node prev=first;
            node curr= first.next;
            while (x!=0 && curr!=null){
                node front=curr.next;
                curr.next=prev;
                prev=curr;
                curr=front;
                x--;
            }
            first.next=prev;
            second.next=curr;
            first=second;
        }
        head= head.next;
        node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
    }
}
