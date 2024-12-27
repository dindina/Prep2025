package week1;

/*
https://leetcode.com/problems/linked-list-cycle/description/
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.val = 10;
        node1.next = node2;

        node2.val = 102;
        node2.next = node3;

        node3.val = 105;
        node3.next = null;

        System.out.println(new LinkedListCycle().hasCycle(node1));


    }

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }


        }

        return false;
    }
}
