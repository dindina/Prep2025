package week5;

import java.util.*;

/*
https://leetcode.com/problems/task-scheduler/description/
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.


 */
public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = new char[] { 'A','A','A','B','B','B'};
        System.out.println(new TaskScheduler().leastInterval(tasks,2));

    }

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char t : tasks) {
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        pq.addAll(counts.values());

        System.out.println("counts " + counts);
        System.out.println("counts.values() " + counts.values());
        System.out.println("pq" + pq);

        int alltime = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            List<Integer> workList = new ArrayList<Integer>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    System.out.println("in loop " + i);
                    workList.add(pq.poll());
                }
            }
            //putting back to the pq
            for (int cnt : workList) {
                if (--cnt > 0) {
                    pq.offer(cnt);
                }
            }
            alltime += !pq.isEmpty() ? cycle : workList.size();
        }

        return alltime;
    }



}
