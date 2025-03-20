package array;
import java.util.*;
/*public class TurnsTile {
}
import java.util.*;*/

class TurnsTile {





    public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        // Write your code here

        Deque<Integer> exitQueue = new LinkedList<>();
        Deque<Integer> entryQueue = new LinkedList<>();
        System.out.println("time "  + time);
        System.out.println("direction "  + direction);

        for(int i=0 ; i< time.size() ; i++){
            if(direction.get(i) == 1){
                exitQueue.offer(i);
            }else{
                entryQueue.offer(i);
            }
        }

        System.out.println("exitQueue "  + exitQueue);
        System.out.println("entryQueue "  + entryQueue);
        List<Integer> result = new ArrayList<>(Collections.nCopies(time.size(), 0));
        int lastUsedDirection = -1;
        int currTime = 0;
        boolean used = false;
        while (!exitQueue.isEmpty() || !entryQueue.isEmpty()) {
            int nextExit = exitQueue.isEmpty() ? Integer.MAX_VALUE : time.get(exitQueue.peek());
            int nextEntry = entryQueue.isEmpty() ? Integer.MAX_VALUE : time.get(entryQueue.peek());

            //both an exit and an entry person are ready.
            if (nextExit <= currTime && nextEntry <= currTime) {
                int nextExitIndex = exitQueue.peek();
                int nextEntryIndex = entryQueue.peek();

                if (!used || lastUsedDirection ==1) { // exit goes first
                    result.set(nextExitIndex, currTime);
                    exitQueue.poll();
                    lastUsedDirection = 1;

                } else { //entry person goes first.
                    result.set(nextEntryIndex, currTime);
                    entryQueue.poll();
                    lastUsedDirection = 0;
                }
            } else if (nextExit <= currTime) { //Only exit queue has people ready:

                int nextExitIndex = exitQueue.peek();
                result.set(nextExitIndex, currTime);
                exitQueue.poll();
                lastUsedDirection = 1;
            } else if (nextEntry <= currTime) {// Only entry queue has people ready:

                int nextEntryIndex = entryQueue.peek();
                result.set(nextEntryIndex, currTime);
                entryQueue.poll();
                lastUsedDirection = 0;
            } else { // No one ready
                currTime = Math.min(nextExit, nextEntry);
                used = false;
                continue;
            }
            currTime++;
            used = true;
        }

        return result;


    }

    public static void main(String[] args) {
        TurnsTile solution = new TurnsTile();

        // Test case 1
        List<Integer> time1 = Arrays.asList(0, 0, 1, 5);
        List<Integer> direction1 = Arrays.asList(0, 1, 1, 0);
        List<Integer> result1 = solution.getTimes(time1, direction1);
        System.out.println(result1); // Expected: [2, 0, 1, 5]
        List<Integer> result2 = solution.getTimes(time1, direction1);

        System.out.println(result2); // Expected: [2, 0, 1, 5]

        // Test case 2
        /*List<Integer> time2 = Arrays.asList(0, 1, 1, 3, 3);
        List<Integer> direction2 = Arrays.asList(0, 1, 0, 0, 1);
        List<Integer> result3 = solution.getTimes(time2, direction2);

        List<Integer> result4 = solution.getTimes1(time1, direction1);
        System.out.println(result3); // Expected: [0, 2, 1, 4, 3]
        System.out.println(result4); // Expected: [0, 2, 1, 4, 3]*/
    }
}
