package Trees;

import java.util.Scanner;

public class preorder_traversal_of_tree {
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
    static void preOrderTraversal(Node root)
    {
        if (root==null)
            return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public static void main(String[] args) {
        Node root = creationOfBinaryTree();
        preOrderTraversal(root);
    }
}
