package graph;

import java.util.*;


public class BFSTraversal {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,2},{0,3},{0,5},{2,1},{3,4},{5,7}
        };
        int vertice = 10 ;
        BFSTraversal obj = new BFSTraversal();
        //List<Integer> path = obj.bfs(vertice,edges);
        //System.out.println("bfs path " +path);

        List<List<Integer>> levelOrder = obj.levelOrderTraversal1(vertice,edges);
        System.out.println("level order " + levelOrder);
    }

    private  List<Integer> bfs(int vertice, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0 ; i < vertice ; i++ )
            graph.add(new ArrayList<>());

        for(int[] arr : edges)
        {
            graph.get(arr[0]).add(arr[1]);
        }
        System.out.println("graph " + graph);

        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty())
        {
            int item = queue.poll();
            result.add(item);

            for(int neighbor : graph.get(item))
            {
                queue.offer(neighbor);
            }

        }

        return result;

    }

    private  List<List<Integer>> levelOrderTraversal1(int vertice, int[][] edges) {

        List<List<Integer>> result = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();

        for(int i =0 ; i < vertice ; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] arr: edges)
        {
            graph.get(arr[0]).add(arr[1]);
        }
        System.out.println(graph);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        result.add(Arrays.asList(0));

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0 ; i <size ; i++)
            {
                Integer item = queue.poll();
                for (int neighbour : graph.get(item))
                {
                    level.add(neighbour);
                    queue.offer(neighbour);

                }

            }
            if(!level.isEmpty())
                result.add(level);

        }


        return result;
    }
}
