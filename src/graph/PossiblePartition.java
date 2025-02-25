package graph;


import java.util.*;
import java.util.List;
/*
https://leetcode.com/problems/possible-bipartition/description/
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.



Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: The first group has [1,4], and the second group has [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Explanation: We need at least 3 groups to divide them. We cannot put them in two groups.
 */
public class PossiblePartition {

    int COLOR = 0; // red = 0 , blue = 1-color =0 ; red = 1-color
    public static void main(String[] args) {
        int [][] dislikes = new int[][]{
                //{1,2},{1,3},{2,4} // true
                {1,2},{1,3},{2,3} // false
        };

        System.out.println(new PossiblePartition().possibleBipartition(3,dislikes));
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<List<Integer>> graph = new ArrayList<>();

        int[] color= new int[n+1];
        for(int i = 1 ; i < color.length ; i++ )
        {
            color[i]=-1;
        }

        for(int i =1 ; i <= color.length ; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int [] edge : dislikes)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i=1 ; i <= n; i++)
        {
            if(color[i] == -1) {

                if (!bfsColor(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean bfsColor(int i, List<List<Integer>> graph, int[] color) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        color[i] = 0;

        while(!queue.isEmpty())
        {
            int curr = queue.poll();

            for(int neigh : graph.get(curr)){
                if(color[neigh] == color[curr])
                    return false;
                if(color[neigh]  == -1)
                {
                    color[neigh] = 1-color[curr];
                    queue.offer(neigh);
                }
            }
        }


        return true;

    }
}
