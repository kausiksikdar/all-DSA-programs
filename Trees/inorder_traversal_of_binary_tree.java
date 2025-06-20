package Trees;

import java.util.Scanner;

public class inorder_traversal_of_binary_tree {
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
    static void inOrderTraversal(Node root)
    {
        if (root==null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
    public static void main(String[] args) {
        Node root = creationOfBinaryTree();
        inOrderTraversal(root);
    }
}
