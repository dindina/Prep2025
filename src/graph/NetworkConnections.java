package graph;

import common.Utils;

import java.util.*;

public class NetworkConnections {

    public static void main(String[] args) {
            int [] [] array = new int[][]{
                    //{0,1}, {0,2}, {0,3}, {1,2} // connected = 3
                    {0,1},{0,2},{1,2} // connected =2

            };

        System.out.println( new NetworkConnections().makeConnected(4,array));

    }

    public void bfs(int node , List<List<Integer>> graph, boolean[] visited)
    {

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){

            int curr = q.poll();
            visited[curr]=true;
            for(int neigh : graph.get(curr)){
                System.out.println("neigh " + neigh);
                if(!visited[neigh]){
                    visited[neigh]=true;
                    q.offer(neigh);
                }
            }
        }
    }
    public int makeConnected(int total, int[][] connections) {

        if (connections.length < total - 1) {
            return -1;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i= 0; i < total ; i++)
            graph.add(new ArrayList<>());
        for(int[] connection : connections){
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[total];
        int connected= 0;
        for(int i =0 ; i < total; i++)
        {
            if(!visited[i]) {
                System.out.println("visiting " + i);
                connected++;
                bfs(i, graph, visited);
            }
        }

        System.out.println("connected " + connected);
        return connected-1;
    }

}
