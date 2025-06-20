package LL;

import java.util.*;

public class detect_loop_in_LL {
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
    static boolean check(ArrayList<Node>visited, Node present){
        for (Node node : visited) {
            if (node == present) {
                return true;
            }
        }
        return false;
    }
    static boolean isLoop(Node head){
        Node present=head;
        ArrayList<Node> visited=new ArrayList<>();
        while (present!=null){
            if (check(visited, present)){
                return true;
            }
            visited.add(present);
            present= present.next;
        }
        return false;
    }
    static boolean isLoopBetter(Node head){
        Node curr=head;
        HashMap<Node,Boolean> map=new HashMap<>();
        while (curr!=null){
            if (map.get(curr)!=null){
                return true;
            }
           else{
               map.put(curr,true);
            }
            curr=curr.next;
        }
        return false;
    }
    static boolean isLoopOptimized(Node head){
        Node slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
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
    public static void main(String[] args) {
        int[] arr={5,2,1,4,6,9,4,73,5};
        Node head=createLL(arr,0,arr.length);
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node tail=temp;
        tail.next=head.next.next.next; //Creation of loop

        //Method-1: create an arraylist that stores the addresses of each node if any address s repeated i.e. loop exists because data may be repeated bt address doesn't
        //TC=O(n^2)
        System.out.println(isLoop(head));

        //Method-2: create hashmap(un-ordered) store all data in that map(By map we find elements by constant time So we decrease the time of arraylist iteration i.e. O(n))
        //TC=O(n), SC=O(n)
        System.out.println(isLoopBetter(head));

        //Method-3: use slow and fast ptr TC=O(n), SC=O(1)
        System.out.println(isLoopOptimized(head));

        //Find length of linked list
        //if loop exist then we move fast ptr by one and again when fast meets second then that will be the length of loop
        System.out.println(loopLength(head));
    }
}
