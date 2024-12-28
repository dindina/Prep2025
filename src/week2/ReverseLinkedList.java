package week2;
import week1.ListNode;


/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
 */
public class ReverseLinkedList {

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
        node3.next = null;

        node4.val =  106;
        node4.next = null;

        ListNode.print(node1);

        ListNode mid = new ReverseLinkedList().reverseList(node1);
        System.out.println("rev");
        ListNode.print(mid);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while ( curr != null )
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

}
