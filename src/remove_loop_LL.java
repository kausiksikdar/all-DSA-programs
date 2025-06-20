public class remove_loop_LL {
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
        temp.next=createLL(arr,index+1,arr.length);
        return temp;
    }
    static void removeLoop1(Node head){
        //Detect the loop
        Node slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
            if (slow==fast){
                break;
            }
        }
        //if loop doesn't exist
        if (fast==null || fast.next==null){
            return;
        }
        //if loop exist...
        fast=head;
        //find the start node of loop
        while (slow!=fast){
            slow= slow.next;
            fast= fast.next;
        }
        //make fast one step ahead of slow
        fast=fast.next;
        //find the last node where we need to break the loop
        while (fast.next!=slow){
            fast= fast.next;
        }
        //Break the loop i.e. make last node address point to null
        fast.next=null;
    }
    static int loopLength(Node head){
        Node slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        int cnt=1;
        if (fast==null || fast.next==null){
            return 0;
        }
        else {
            slow=fast.next;
            while (slow!=fast){
                cnt++;
                slow= slow.next;
            }
        }
        return cnt;
    }
    static void removeLoop2(Node head){
        //find the length of loop, if exist...
        int cnt=loopLength(head);
        if (cnt==0) return; //if loop length is '0' i.e. loop doesn't exist
        //Ahead fast cnt steps with respect to slow
        Node slow=head,fast=head;
        while (cnt!=0){
            fast=fast.next;
            cnt--;
        }
        //find the start node of loop
        while (slow!=fast){
            slow= slow.next;
            fast= fast.next;
        }
        //make fast one step ahead of slow
        fast=fast.next;
        //find the last node where we need to break the loop
        while (fast.next!=slow){
            fast= fast.next;
        }
        //Break the loop i.e. make last node address point to null
        fast.next=null;
    }
    public static void main(String[] args) {
        int[] arr={5,2,1,4,6,9,4,73,5};
        Node head=createLL(arr,0,arr.length);
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node tail=temp;
        tail.next=head.next.next.next; //Creation of loop
        removeLoop1(head);
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        //Again creation of loop
        temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        tail=temp;
        tail.next=head.next.next.next;
        removeLoop2(head);
        //Print
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
