package LL;

public class merge_k_sorted_LL {
    public static class Node {
        int data;
        Node bottom;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createLL(int[] arr, int index, int size) {
        if (index == size) return null;
        Node temp = new Node(arr[index]);
        temp.bottom = createLL(arr, index + 1, size);
        return temp;
    }

    static Node merge(Node head1, Node head2) {
        Node head = new Node(-1);//Dummy node
        Node tail = head;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.bottom = head1;
                head1 = head1.bottom;
            } else {
                tail.bottom = head2;
                head2 = head2.bottom;
            }
            tail = tail.bottom;
        }
        if (head1 != null) tail.bottom = head1;
        else tail.bottom = head2;
        return head.bottom;
    }

    static Node mergeLL(Node[] arr, int k) {
        Node head = arr[0];
        for (int i = 1; i < k; i++) {
            head = merge(head, arr[i]);
        }
        return head;
    }
    static void mergeSort(Node[] arr, int start, int end){
        if (start>=end) return;
        int mid=start+((end-start)/2);
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        arr[start]=merge(arr[start],arr[mid+1]);
    }
    public static void main(String[] args) {
        //creation of desired LL
        int k = 4;
        Node[] arr = new Node[k];
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 5, 6};
        int[] arr3 = {3, 4, 5};
        int[] arr4 = {5, 8, 9};
        Node head1 = createLL(arr1, 0, arr1.length);
        Node head2 = createLL(arr2, 0, arr2.length);
        Node head3 = createLL(arr3, 0, arr3.length);
        Node head4 = createLL(arr4, 0, arr4.length);

        arr[0] = head1;
        arr[1] = head2;
        arr[2] = head3;
        arr[3] = head4;

        //call the mergeLL function
        Node head = mergeLL(arr, k);

        //Print
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
    }
}
