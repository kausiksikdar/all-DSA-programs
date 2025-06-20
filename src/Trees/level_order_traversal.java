package Trees;

import javax.swing.event.ListDataListener;
import java.util.*;

public class level_order_traversal {
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
    static void levelorder(Node root, List<List<Integer>> ans)
    {
        if (root==null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            while (n-->0) {
               Node node = q.peek();
                temp.add(node.data);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
               q.remove();
            }
            ans.add(temp);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        Node root = creationOfBinaryTree();
        levelorder(root,ans);
        System.out.println(ans);
    }
}
