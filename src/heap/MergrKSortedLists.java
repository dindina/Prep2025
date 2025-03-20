package heap;


import linkedlist.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergrKSortedLists {

    public static void main(String[] args) {

        ListNode list1 = ListNode.getSampleList(Arrays.asList(1,2,3));
        ListNode list2 = ListNode.getSampleList(Arrays.asList(21,33,110));
        ListNode list3 = ListNode.getSampleList(Arrays.asList(4,5,6));
        ListNode merged = mergeKLists(new ListNode[]{list1,list2,list3});
        System.out.println(merged);


    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(a->a.val));
        for(ListNode node : lists)
        {
            if(node != null)
            heap.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (! heap.isEmpty())
        {
            ListNode node = heap.poll();

            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                heap.offer(node.next);
            }


        }

        return dummy.next;


    }


}

