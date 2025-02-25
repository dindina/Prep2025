package graph;

import java.util.*;

public class Provinces {

    public static void main(String[] args) {
        int [][] edgs = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1},
        };

        System.out.println(new Provinces().findCircleNum(edgs));
    }

    public int findCircleNum(int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        int total = edges.length;
        for (int i = 0; i < total; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {

                if (edges[i][j] == 1 & i!=j) {
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[total];
        int connected = 0;

        for(int i=0 ; i < total ; i++){
            if(!visited[i])
            {
                connected++;
                bfs(i , graph,visited);
            }
        }

        return connected;


}

public void bfs(int node , List<List<Integer>> graph  , boolean[] visited)
{
    Queue<Integer> queue = new LinkedList<>();

    queue.offer(node);

    while(!queue.isEmpty())
    {
        int curr = queue.poll();
        visited[curr] = true;
        for(int neighbour : graph.get(curr)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                queue.offer(neighbour);
            }
        }
    }

}
}