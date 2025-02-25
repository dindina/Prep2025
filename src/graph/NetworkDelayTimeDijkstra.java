package graph;


import java.util.*;

/*
https://leetcode.com/problems/network-delay-time/description
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 */
public class NetworkDelayTimeDijkstra {

    public static void main(String[] args) {
        int[][] network = new int [][]{
                //{2,1,1},{2,3,1},{3,4,1}
                {0,1,100},{1,2,100},{0,2,500},{0,3,50},{3,2,20}
        };
        int total=3;
        int source=0;

        System.out.println(new NetworkDelayTimeDijkstra().networkDelayTime(network,total,source));


    }

    public int networkDelayTime(int[][] times, int total, int source) {

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=1 ; i <= total+1 ; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : times){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }

        //System.out.println(graph);

        Map<Integer, Integer> dist = new HashMap<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.offer(new Pair(source,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            System.out.println("curr->" + curr);
            int currNode = curr.node;
            int currTime = curr.distance;

            // using the pq ensure that the first node is having the least distance
            // if we dont add this condition , then the same node will be again added to the pq

            if (dist.containsKey(currNode)) {
                System.out.println("discarding " + currNode);
                continue;
            }

            dist.put(currNode, currTime);

            for(Pair neighour : graph.get(currNode))
            {
                int neighBourNode = neighour.node;
                int neighBourDist = neighour.distance;
                System.out.println("neighBourNode->" + neighBourNode);
                System.out.println("neighBourDist->" + neighBourDist);
                pq.offer(new Pair(neighBourNode,currTime+neighBourDist));
            }


        }
        System.out.println(dist);
        if (dist.size() != total) return -1; // If not all nodes are reached, return -1
        return Collections.max(dist.values());

    }

    class Pair{
        int node;
        int distance;

        Pair(int n,int k)
        {
            node=n;
            distance=k;
        }

        @Override
        public String toString(){
            return "Node="+node+",distance="+distance;
        }

    }
}
