package graph;

import common.Utils;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule-ii/description/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

 */
public class CourseSchedule2 {

    public static void main(String[] args) {
        int [][] prereq = new int[][]{
                {1,0},{2,0},{3,1},{3,2}
        };

        System.out.println("result");
        Utils.printArray(new CourseSchedule2().findOrder(4,prereq));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // form the graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ;i <numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int [] arr : prerequisites)
        {
            graph.get(arr[1]).add(arr[0]);
        }
        System.out.println(graph);

        int[] indegree = new int[numCourses];

        for(int i=0 ;i <numCourses;i++) {
            for( int v : graph.get(i)){
                indegree[v]++;
            }
        }

        Utils.printArray(indegree);

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0 ;i <numCourses;i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }

        int[] order = new int[numCourses];
        int count =0;

        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            order[count++] = curr;

            for(int course : graph.get(curr))
            {
                indegree[course]--;
                if(indegree[course] == 0)
                {
                    queue.offer(course);
                }
            }
        }

        if(numCourses == count)
            return order;
        return new int[0];


    }
}
