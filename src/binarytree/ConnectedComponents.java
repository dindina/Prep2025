package binarytree;

import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1},{1,2},{2,0},{3,4},{4,5},{7,8}
        };

        System.out.println(new ConnectedComponents().usingBFS(edges,9));
        count=0;
        System.out.println(new ConnectedComponents().usingDFS(edges,9));

    }

    static int count = 0;

    public int usingDFS(int[][] edges , int total ){
        if(edges == null)
            return 0;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i <total; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        boolean [] visited = new boolean[total];
        for(int i=0; i < total; i++){
            if(!visited[i]) {
                count++;
                dfs24(i, graph, visited);
            }
        }
        return count;

    }

    private void dfs24(int i, List<List<Integer>> graph, boolean[] visited) {

        for(int neighbour : graph.get(i)){
            if(!visited[neighbour])
            {
                visited[neighbour]=true;
                dfs24(neighbour,graph,visited);
            }
        }
    }

    public int usingBFS(int[][] edges , int total ){

        if(edges == null)
            return 0;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i <total; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        boolean [] visited = new boolean[total];
        for(int i=0; i < total; i++){
            if(!visited[i]) {
                count++;
                bfs24(i, graph, visited);
            }
        }
        return count;

    }

    private void bfs24(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neighbour : graph.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                }
            }
        }
    }
}
