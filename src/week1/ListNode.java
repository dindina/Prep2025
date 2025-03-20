package week1;

 public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public static void print(ListNode start)
     {
         while(start!=null)
         {
             System.out.print(start.val + "=>");
             start = start.next;
         }
         System.out.println();
     }
  }
