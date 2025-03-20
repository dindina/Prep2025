package graph;

import common.Utils;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule/description/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi]
indicates that you must take course bi first if you want to take course ai.

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
        int [][] prereq = new int[][]{
                {1,4},{2,4},{3,1},{3,2}
        };

        System.out.println(new CourseSchedule().canFinish(5,prereq));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] temp : prerequisites)
        {
            graph.get(temp[0]).add(temp[1]);
        }
        System.out.println("graph " + graph);
        //calculate the indgree
        int[] indegree = new int[numCourses];

        for(int i =0 ; i <numCourses; i++ )
            for(int v : graph.get(i))
            {
                indegree[v]++;
            }
        Utils.printArray(indegree);


        Queue<Integer> queue = new LinkedList<>();
        for(int i =0 ; i <numCourses ; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        int count =0;
        while(!queue.isEmpty()){

            int curr = queue.poll();
            System.out.println("curr" + curr);
            count ++;
            for(int neigh : graph.get(curr)){
                indegree[neigh] = indegree[neigh]-1;
                if(indegree[neigh] == 0){
                    queue.offer(neigh);
                }

            }

        }

        return count == numCourses;



    }

}
