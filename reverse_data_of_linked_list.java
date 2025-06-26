import java.util.ArrayList;

public class reverse_data_of_linked_list {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            val=data;
        }
    }
    static ListNode CreateLinkedList(int[] arr, int index, int size){
        if (index==size){
            return null;
        }
        ListNode temp=new ListNode(arr[index]);
        temp.next=CreateLinkedList(arr,index+1,size);
        return temp;
    }
    public static void main(String[] args) {
        //Creation of Linked List
        int[] array={1,2,3,4,5};
        ListNode head=CreateLinkedList(array,0,array.length);
        System.out.print("Creation of linked list : ");
        //Print
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
        ArrayList<Integer> answerStorage=new ArrayList<>();
        temp=head;
        while (temp!=null){
            answerStorage.add(temp.val);
            temp=temp.next;
        }
        int i=answerStorage.size()-1;
        temp=head;
        while (temp!=null){
            temp.val=answerStorage.get(i);
            i--;
            temp=temp.next;
        }
        System.out.print("Linked List in reversed way : ");
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}
