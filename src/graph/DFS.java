package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {

    static Set<Integer> visited = new HashSet<>();
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,2},{0,3},{0,5},{2,1},{3,4},{5,7}
        };
        int vertice = 9 ;
        Set<Integer> path = dfs(vertice,edges);
        System.out.println("bfs path " +path);
    }
    public static Set<Integer> dfs(int vertice, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0 ; i < vertice; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);

        }

        List<Integer> path = new ArrayList<>();
        visited.add(0);
        dfsHelper(graph,0,visited);
        return visited;

    }

    public static void dfsHelper(List<List<Integer>> graph , int curr , Set<Integer> visited)
    {
        List<Integer> neighbours = graph.get(curr);
        for( int temp : neighbours)
        {
            if(!visited.contains(temp)) {
                visited.add(temp);
                dfsHelper(graph, temp, visited);
            }
        }
    }
}
