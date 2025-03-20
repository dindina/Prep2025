package linkedlist;

import java.util.*;

public class ListNode {

      public int val;
      public ListNode next;
      public ListNode(int x) {
          val = x;
          next = null;
      }

      public static ListNode getSampleList(List<Integer> list)
      {
          ListNode head = null;
          head = new ListNode(list.get(0));
          ListNode prev = head;
          for(int i = 1 ; i < list.size() ; i++) {

              ListNode curr = new ListNode(list.get(i));
              prev.next = curr;
              prev = curr;

          }
          return head;
      }

      @Override
      public String toString()
      {
          ListNode temp = this;
          StringBuilder sbr = new StringBuilder();
          while(temp != null)
          {
              sbr.append(temp.val+",");
              temp = temp.next;
          }
          return sbr.toString();
      }
  }
