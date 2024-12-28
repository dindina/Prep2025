package week2;

import week1.ListNode;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();

        node1.val = 10;
        node1.next = node2;

        node2.val = 102;
        node2.next = node3;

        node3.val =  105;
        node3.next = node4;

        node4.val =  106;
        node4.next = null;

        ListNode.print(node1);

        ListNode mid = new MiddleOfLinkedList().middleNode(node1);
        System.out.println("middle");
        ListNode.print(mid);


    }
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }
}
