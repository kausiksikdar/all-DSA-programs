package Trees;

import java.util.Scanner;

public class sum_of_binary_tree {
    public static class Node {
        int data;
        Node left, right;
        Node(int val) {
            data = val;
            left=right=null;
        }
    }
    static Node creationOfBinaryTree()
    {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();

        if (x==-1)
            return null;

        Node temp = new Node(x);
        temp.left=creationOfBinaryTree();
        temp.right=creationOfBinaryTree();
        return temp;
    }
    static int sumOfBinaryTree(Node root, int sum)
    {
        if (root==null)
            return 0;

        sum+=sumOfBinaryTree(root.left,sum);
        sum+=sumOfBinaryTree(root.right,sum);
        sum+=root.data;
        return sum;
    }
    public static void main(String[] args) {
        Node root = creationOfBinaryTree();
        System.out.println(sumOfBinaryTree(root,0));
    }
}
