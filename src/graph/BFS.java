package graph;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,2},{0,3},{0,5},{2,1},{3,4},{5,7}
        };
        int vertice = 10 ;
        List<Integer> path = bfs(vertice,edges);
        System.out.println("bfs path " +path);

        List<List<Integer>> levelOrder = levelOrderTraversal(vertice,edges);
        System.out.println("level order " + levelOrder);
    }
    public static List<List<Integer>> levelOrderTraversal(int vertice, int[][] edges) {

        List<List<Integer>> result = new ArrayList<>();
        if(edges.length ==0)
            return result;

        // create the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i < vertice; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int [] edge :edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }

        System.out.println("graph " + graph);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(0);
        queue.offer(0);
        result.add(Arrays.asList(0));

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> currList = new ArrayList<>();
            for(int i =0 ; i < size ; i++)
            {
                int curr = queue.poll();

                for(int neighbour : graph.get(curr))
                {
                    currList.add(neighbour);
                    System.out.println("added neighbour " + neighbour);
                    queue.offer(neighbour);
                }
            }
            if(!currList.isEmpty())
                result.add(currList);

        }

        return result;





    }


    public static List<Integer> bfs(int vertice, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        List<Integer> result = new ArrayList<>();


        for(int i= 0 ; i < vertice ; i++)
        {
            graph.add(new ArrayList<>());
        }

        for( int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]); // for directed
            //graph.get(edge[1]).add(edge[0]); for undirected
        }
        System.out.println("graph " + graph);


        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();


        visited.add(0);
        queue.offer(0);


        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            //System.out.println("curr = " + curr);
            result.add(curr);

            for(int i : graph.get(curr))
            {
                //System.out.println("i = " + i);
                if(!visited.contains(i))
                {
                    visited.add(i);
                    queue.offer(i);
                }

            }
        }

        return result;



    }


}
