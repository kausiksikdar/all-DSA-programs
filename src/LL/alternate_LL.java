package LL;

public class alternate_LL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    static Node createLL(int[] arr, int n, int index){
        if (index==n) return null;
        Node temp=new Node(arr[index]);
        temp.next=createLL(arr, arr.length,index+1);
        return temp;
    }
    static void alternatingLL(Node h1, Node h2){
        if (h1==null || h2==null){
            return;
        }
        Node f1=h1.next;
        Node f2=h2.next;
        h1.next = h2;
        h2.next=f1;
        alternatingLL(f1,f2);
    }
    public static void main(String[] args) {
        int[] arr1={10,9};
        int[] arr2={6,5,4,8,2,1};
        Node head1=createLL(arr1,arr1.length,0);
        Node head2=createLL(arr2,arr2.length,0);
        int len1=0,len2=0;
        Node length1=head1,length2=head2;
        while (length1!=null){
            len1++;
            length1=length1.next;
        }
        while (length2!=null){
            len2++;
            length2=length2.next;
        }
        Node tempo;
        int cnt=0;
        if (len1>len2){
             tempo=head1;
             while (cnt!=len2){
                 tempo=tempo.next;
                 cnt++;
             }
        }
        else {
            tempo=head2;
            while (cnt!=len1){
                tempo=tempo.next;
                cnt++;
            }
        }
        alternatingLL(head1,head2);
        Node temp=head1;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=tempo;
        temp=head1;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
