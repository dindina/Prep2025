package week1;

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     static void print(ListNode start)
     {
         while(start!=null)
         {
             System.out.print(start.val + "=>");
             start = start.next;
         }
         System.out.println();
     }
  }
