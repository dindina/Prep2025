package graph;

import common.Utils;

import java.util.*;

public class DetectCycleInA_A_DirectedGraph {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                //{1,0},{0,1},{0,2},{1,3},{4,1},{4,5},{5,3}
                //{1,0},{0,1}
                {0,1},{1,2},{2,3},{3,0},{0,4} //5
        };

        System.out.println("detectCycle " + detectCycle(edges,5));

    }




    public static boolean detectCycle(int[][] edges, int total)
    {


        int[] inDegree = new int[total];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i <total ; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        System.out.println("priting indegree");
        Utils.printArray(inDegree);

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i< total; i++)
        {
            if(inDegree[i]  == 0 ) // to start from root
                queue.offer(i);
        }

        System.out.println(queue);
        int visited = 0;
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            visited++;
            for(int n : graph.get(curr))
            {
                System.out.println("checking " + n);
                System.out.println("inDegree[n] " + inDegree[n]);
                inDegree[n] = inDegree[n]-- ;
                if(inDegree[n] == 0)
                {
                    System.out.println("ofeering " + n);
                    queue.offer(n);
                }
            }

        }
        System.out.println("visted " + visited);
        System.out.println("total " + total);
        return visited!=total;
    }

}
