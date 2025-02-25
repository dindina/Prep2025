package graph;


import java.util.*;

/*
https://leetcode.com/problems/graph-valid-tree/description
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true

Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                //{0,1},{0,2},{0,3},{1,4} // n= 5 , true
                //{0,1},{1,2},{2,3},{3,4},{0,4} // n= 5 , false
                {0,1},{1,2},{2,0}

        };

        System.out.println(new GraphValidTree().validTree(4,edges));

    }

    public boolean validTree(int n, int[][] edges) {

        //For the graph to be a valid tree, it must have exactly n - 1 edges.
        // Any less, and it can't possibly be fully connected. Any more edges, and it has to contain cycles.
        if(edges.length != n-1)
        {
            System.out.println("failed edges.length " + edges.length);
            System.out.println("n-1 " + (n-1));
            return false;
        }

        // perform plain bfs
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i< n; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        while(! q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;

            for(int neighbour : graph.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }

        for(int i=0 ;i <n ; i++){
            if(visited[i] == false) {
                System.out.println("not visited " + i);
                return false;
            }
        }
        return true;



    }
}
