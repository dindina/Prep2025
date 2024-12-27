package week1;


/*
https://leetcode.com/problems/merge-two-sorted-lists/description/
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.


 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        head1.val = 5;
        head1.next = new ListNode();
        head1.next.val = 6;

        head1.next.next = new ListNode();
        head1.next.next.val = 7;

        head1.next.next.next = new ListNode();
        head1.next.next.next.val = 8;

        ListNode.print(head1);

        ListNode head2 = new ListNode();
        head2.val = 1;
        head2.next = new ListNode();
        head2.next.val = 2;

        head2.next.next = new ListNode();
        head2.next.next.val = 10;
        ListNode.print(head2);

        ListNode result = new MergeTwoSortedLists().mergeTwoLists(head2,head1);
        System.out.println("result");
        ListNode.print(result);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;

        }

        if (list1 != null) {
            tail.next = list1;
        }else if (list2 != null) {

            tail.next = list2;
        }
        return  head.next;



    }
}
