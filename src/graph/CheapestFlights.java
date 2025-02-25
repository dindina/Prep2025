package graph;

import java.util.*;

/*
https://leetcode.com/problems/cheapest-flights-within-k-stops
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
public class CheapestFlights {
    public static void main(String[] args) {
        int[][] flights = new int[][]{
                //{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}
                {0,1,100},{1,2,100},{0,2,500}
        };

        System.out.println(new CheapestFlights().findCheapestPrice(3,flights,0,2,1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> graph = new ArrayList<>();

        for(int i = 0 ; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : flights)
        {
            int flight1 = edge[0];
            int flight2 = edge[1];
            int price = edge[2];
            graph.get(flight1).add(new Pair(flight2,price));
        }
        System.out.println(graph);
        // map of flight to cost
        Map<Integer,Integer> map1 = new HashMap<>();
        // map of flight to stop
        Map<Integer,Integer> map2 = new HashMap<>();


        PriorityQueue<Tuple> pq =
                new PriorityQueue<>(Comparator.comparingInt(value -> value.price));


        pq.offer(new Tuple(src,0,k+1));
        int [] steps = new int[n];
        while(!pq.isEmpty())
        {
            Tuple curr = pq.poll();
            int currCity = curr.city;
            int currPrice = curr.price;
            int currSteps = curr.steps;

            if(currCity==dst)
                return currPrice;

            if (steps[currCity] >= currSteps) {
                continue;
            }


            steps[currCity] = currSteps;

            for(Pair neighbour : graph.get(currCity)){

                int neighFlight = neighbour.node;
                int neighPrice = neighbour.price;
                pq.offer(new Tuple(neighFlight,currPrice+neighPrice, currSteps-1));

            }

        }


        return -1;

    }

    class Tuple{
        int city;
        int price;

        int steps;

        Tuple(int m,int k , int l)
        {
            city=m;
            price=k;
            steps=l;
        }
    }
    class Pair{
        int node;
        int price;


        Pair(int m,int k)
        {
            node=m;
            price=k;
        }
    }
}
