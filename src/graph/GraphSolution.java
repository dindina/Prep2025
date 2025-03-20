package graph;

import java.util.*;

class GraphSolution {

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= cityNodes; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < cityFrom.size(); i++) {
            graph.get(cityFrom.get(i)).add(cityTo.get(i));
            graph.get(cityTo.get(i)).add(cityFrom.get(i));
        }

        // Perform BFS to calculate distances from the company
        int[] distances = new int[cityNodes + 1];
        Arrays.fill(distances, -1);
        distances[company] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(company);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (distances[v] == -1) {
                    distances[v] = distances[u] + 1;
                    queue.offer(v);
                }
            }
        }

        // Create a list to store cities to be visited
        List<int[]> cities = new ArrayList<>();
        for (int i = 1; i <= cityNodes; i++) {
            if (i != company && distances[i] != -1) {
                cities.add(new int[]{i, distances[i]});
            }
        }

        // Sort cities by distance and then by city number
        Collections.sort(cities, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        // Create the result list
        List<Integer> result = new ArrayList<>();
        for (int[] city : cities) {
            result.add(city[0]);
        }

        return result;
    }

    public static void main(String[] args) {
        /*int cityNodes = 4;
        List<Integer> cityFrom = Arrays.asList(1, 2, 2);
        List<Integer> cityTo = Arrays.asList(2, 3, 4);
        int company = 1;

        List<Integer> result = order(cityNodes, cityFrom, cityTo, company);
        System.out.println(result); */

        int cityNodes = 5;
        List<Integer> cityFrom = Arrays.asList(1,1,1,2,3 );
        List<Integer> cityTo = Arrays.asList(2,5,3,4,5);
        int company = 1;

        List<Integer> result = order(cityNodes, cityFrom, cityTo, company);
        System.out.println(result);
    }
}
