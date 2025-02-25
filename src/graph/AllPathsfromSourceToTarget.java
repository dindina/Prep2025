package graph;

import java.util.*;

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

        The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
*

 */

public class AllPathsfromSourceToTarget {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                //{0,1},{0,2},{0,3},{1,4} // n= 5 , true
                //{0,1},{1,2},{2,3},{3,4},{0,4} // n= 5 , false
                {1,3}, {3,0,1}, {2}, {0}

        };

        System.out.println(new AllPathsfromSourceToTarget().allPathsSourceTarget(edges));
        //System.out.println(new AllPathsfromSourceToTarget().pathExists(edges,0,3));


    }

    public boolean pathExists(int[][] graph, int src , int dest){

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(src);
        visited.add(src);
        while (! queue.isEmpty()){
            int curr = queue.poll();
            if(curr == dest){
                return true;
            }
            for(int neighour : graph[curr]){
                if(!visited.contains(neighour)){
                    visited.add(neighour);
                    queue.offer(neighour);
                }
            }

        }

        return false;


    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int src = 0;
        int dest = graph.length-1;
        System.out.println("dest " + dest);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        backtrack(src, dest, graph, result, current);
        return result;
    }

    private void backtrack(int src, int dest, int[][] graph, List<List<Integer>> result, List<Integer> current) {

        if (src == dest) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int temp : graph[src]) {

            current.add(temp);
            backtrack(temp, dest, graph, result, current);
            current.remove(current.size() - 1);
        }
    }
}