import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(Comparator.reverseOrder());
        queue.add(1);
        queue.add(110);
        queue.add(2);
        queue.add(-1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
