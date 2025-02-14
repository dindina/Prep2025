package graph;

import java.util.*;

public class GrapthPractise {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,2},{0,3},{0,5},{2,1},{3,4},{5,7}
        };
        int vertice = 8 ;
        List<Integer> bfspath =bfsTraversal(vertice,edges);
        System.out.println("bfs path " +bfspath);

        List<List<Integer>> levelOrderBFS =levelOrderBFS(vertice,edges);
        System.out.println("levelOrderBFS path " +levelOrderBFS);

        List<Integer> dfspath =dfsTraversal(vertice,edges);
        System.out.println("dfs path " +dfspath);



    }



    public static List<List<Integer>> levelOrderBFS(int vertice, int[][] edges){

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;  i < vertice ; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for(int i=0;  i <size ; i++){

                int curr = queue.poll();
                level.add(curr);
                for(int neighbour : graph.get(curr)){
                    queue.offer(neighbour);
                }
            }
            if(!level.isEmpty()){
                result.add(level);
            }
        }


        return result;



    }


    private static List<Integer> dfsTraversal(int vertice, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i < vertice; i++)
            graph.add(new ArrayList<>());

        for(int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }

        List<Integer> result = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        result.add(0);

        graphDfsHelper(0, graph , visited , result);
        return result;

    }

    private static void graphDfsHelper(Integer start , List<List<Integer>> graph, Set<Integer> visited, List<Integer> result) {

        List<Integer> neighbours = graph.get(start);
        for(int neighbour : neighbours){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                result.add(neighbour);
                graphDfsHelper(neighbour, graph , visited , result);
            }
        }

    }


    private static List<Integer> bfsTraversal(int vertice, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();


        for(int i=0 ; i <vertice; i++)
            graph.add(new ArrayList<>());

        for(int [] edge  : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }

        System.out.println("graph " + graph);

        Deque<Integer> q= new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        List<Integer> result = new ArrayList<>();
        result.add(0);

        while(!q.isEmpty()){

            int curr = q.poll();
            List<Integer> neighbours = graph.get(curr);
            for (int neighbour : neighbours){

                if(!visited.contains(neighbour))
                {
                    visited.add(neighbour);
                    q.offer(neighbour);
                    result.add(neighbour);
                }
            }

        }

        return result;

    }


}
