package week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/course-schedule/description/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int [][] prerequisites = new int[][]{
                {0,1},{2,3},{4,5}
        };
        int course = 6;

        System.out.println(new CourseSchedule().canFinish(course,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        // add the in degree 0 alone to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        /// perform bfs
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            // find the neighbour of current course
            List<Integer> list = graph.get(course);
            for (int i : list) {
                //reduce the indegree for that retrieved dependent course .
                // Why? : because we have already removed 0 from the queue ,
                // so that means the dependent of that course 0 which was 1 ,
                // has now no prerequisites.
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

        }
        return count == numCourses;


    }
}
