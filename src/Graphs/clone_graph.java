package Graphs;

import java.util.*;

public class clone_graph {
    static class Node
    {
        int val;
        ArrayList<Node> neighbors;
        Node(int val)
        {
            this.val = val;
            neighbors = new ArrayList<>();
        }
        Node(int val, ArrayList<Node> neighbours)
        {
            this.val = val;
            this.neighbors = neighbours;
        }
    }
    static Node dfs(Node node, HashMap<Node, Node> map)
    {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node neighbour: node.neighbors)
        {
            if(!map.containsKey(neighbour))
            {
                newNode.neighbors.add(dfs(neighbour,map));
            }
            else
            {
                newNode.neighbors.add(neighbour);
            }
        }
        return newNode;
    }
    static Node cloneGraph(Node node)
    {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
//        return dfs(node,map);

        //Using Breadth-First Search
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        q.add(node);

        while (!q.isEmpty()) {
            Node currNode = q.poll();

            for (Node neighbor : currNode.neighbors) {
                //Here the hashmap works as visited array
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor); //if the current node is not visited then only add to queue
                }

                // Always add cloned neighbor to the cloned node's neighbor list
                map.get(currNode).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
    public static void main(String[] args) {
        // Create graph manually
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloned = cloneGraph(node1);

        // Print original and cloned to verify
        System.out.println("Original: " + node1.val + " -> " + node1.neighbors.stream().map(n -> n.val).toList());
        System.out.println("Cloned: " + cloned.val + " -> " + cloned.neighbors.stream().map(n -> n.val).toList());
    }

}
