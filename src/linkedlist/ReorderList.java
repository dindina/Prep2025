package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

https://neetcode.io/problems/reorder-linked-list
Reorder Linked List
You are given the head of a singly linked-list.

The positions of a linked list of length = 7 for example, can intially be represented as:

[0, 1, 2, 3, 4, 5, 6]

Reorder the nodes of the linked list to be in the following order:

[0, 6, 1, 5, 2, 4, 3]

Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:

[0, n-1, 1, n-2, 2, n-3, ...]

You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.

Example 1:

Input: head = [2,4,6,8]

Output: [2,8,4,6]
Example 2:

Input: head = [2,4,6,8,10]

Output: [2,10,4,8,6]


 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(6);
        printList1(root);
        printList(root);
        //reorderList(root);

        ListNode copy = copy(root, new HashMap<>());
        printList1(copy);
        printList(copy);
    }

    public static ListNode copy(ListNode node, HashMap<ListNode,ListNode> map){
        if(node == null)
            return null;
        ListNode new1 = new ListNode(node.val);
        map.put(new1,node);
        new1.next = copy(node.next,map);
        copy(node.next,map);
        return new1;
    }

    public static void printList(ListNode root) {
        ListNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;

        }
        System.out.println();
    }
    public static void printList1(ListNode root) {
        ListNode curr = root;
        while (curr != null) {
            System.out.print(curr.hashCode()+"->");
            curr = curr.next;

        }
        System.out.println();
    }

    public static ListNode deleteNode(ListNode head , Integer node) {

        if(head.val == node) {
            head = head.next;
            return head;
        }
        ListNode curr = head;
        ListNode prev = head;
        while(curr != null)
        {
            if(curr.val == node){
                  prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void reorderList(ListNode head) {

        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node=head;
        while(node!=null){
            list.add(node);
            node=node.next;
        }
        int j=list.size()-1;
        for(int i=0;i<=list.size()/2;i++){
            if(i==(list.size()/2) || j==(list.size()/2)){
                list.get(j).next=list.get(i).next;
                list.get(i).next=list.get(j);
                list.get(j).next=null;
            }else{
                list.get(j).next=list.get(i).next;
                list.get(i).next=list.get(j);
                j--;
            }
        }

    }
}
