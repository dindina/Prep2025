package linkedlist;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        node1.next = new ListNode(11);
        node1.next.next = new ListNode(12);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(13);

        ListNode merged = mergeList(node1,node2);
        System.out.println(merged);
    }

    private static ListNode mergeList(ListNode node1, ListNode node2) {

        if(node1 == null && node2 != null)
            return node2;

        if(node1 != null && node2 == null)
            return node1;

        if(node1 == null && node2 == null)
            return null;

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while(node1 != null && node2 != null)
        {
            if(node1.val < node2.val)
            {
                tail.next=node1;
                node1 = node1.next;
                tail = tail.next;
            }
            else {
                tail.next=node2;
                node2=node2.next;
                tail = tail.next;
            }
        }
        if(node1 != null)
            tail.next = node1;
        else if (node2 != null)
            tail.next = node2;

        return head.next;

    }
}
