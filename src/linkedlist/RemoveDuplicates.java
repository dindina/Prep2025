package linkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {

        ListNode head = ListNode.getSampleList(Arrays.asList(1,2,3,2,3));

        System.out.println(head);
        System.out.println(removeDup(head));
    }

    public static ListNode removeDup(ListNode head){

        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = head;
        while(curr!=null)
        {
            if(set.contains(curr.val))
            {
                prev.next = curr.next;

            }
            else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
