package linkedlist;

import java.util.HashMap;

/*
https://neetcode.io/problems/copy-linked-list-with-random-pointer
Copy Linked List with Random Pointer
You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.

Create a deep copy of the list.

The deep copy should consist of exactly n new nodes, each including:

The original value val of the copied node
A next pointer to the new node corresponding to the next pointer of the original node
A random pointer to the new node corresponding to the random pointer of the original node
Note: None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if it does not point to any node.
 */
public class CopyWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head.next = node1;
        head.random = node3;

        node1.next = node2;
        node1.random = head;

        node2.next = node3;
        node2.random = null;

        node3.next = node4;
        node3.random = node1;

        node4.next = null;
        node4.random = node2;

        printList(head);
        Node clone = copyRandomList(head, new HashMap<>());
        printList(clone);




    }
    public static void printList(Node root) {
        Node curr = root;
        while (curr != null) {
            //System.out.print(curr.hashCode()+"->");
            int random = -1;
            if(curr.random != null)
                random = curr.random.val;
            System.out.print(curr.val+","+random+"->");
            curr = curr.next;

        }
        System.out.println();
    }

    public static Node copyRandomList(Node node, HashMap<Node,Node> map){
        if(node == null)
            return null;
        Node new1 = new Node(node.val);
        map.put(node,new1); // map of node-> clone
        new1.next = copyRandomList(node.next,map);
        if(map.containsKey(node.random)){
            new1.random = map.get(node.random);
        }
        else {
            new1.random = copyRandomList(node.random,map);
        }
        copyRandomList(node.next,map);
        return new1;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
