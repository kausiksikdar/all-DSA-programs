public class sort_0s_1s_2s_LL {
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
        int[] arr={2,0};
        Node head=createLL(arr,0,arr.length),temp;

        Node zeroHead = new Node(-1);
        Node zero = zeroHead;

        Node oneHead = new Node(-1);
        Node one = oneHead;

        Node twoHead = new Node(-1);
        Node two = twoHead;

        Node present = head;
        if (head.next!=null || head!=null) {
            while (present != null) {
                if (present.data == 0) {
                    zero.next = present;
                    zero = present;
                }
                else if (present.data == 1) {
                    one.next = present;
                    one = present;
                }
                else {
                    two.next = present;
                    two = present;
                }
                present = present.next;
            }
            zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
            one.next=twoHead.next;
            two.next=null;
        }
        else {
            System.out.println(head);
        }
        Node newHead=zeroHead.next;
        //Print
        temp=newHead;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
