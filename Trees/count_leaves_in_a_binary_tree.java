package Trees;

import java.util.Scanner;

public class count_leaves_in_a_binary_tree {
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
    static int noOfLeaves(Node root)
    {
        if (root==null)
            return 0;
        if (root.left==null && root.right==null)
            return 1;

         return noOfLeaves(root.left)+noOfLeaves(root.right);
    }
    public static void main(String[] args) {
        Node root = creationOfBinaryTree();
        System.out.println(noOfLeaves(root));
    }
}