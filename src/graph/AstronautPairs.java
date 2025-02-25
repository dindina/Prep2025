package graph;

import java.util.*;

public class AstronautPairs {

    public static int astronautPairs(int n, List<List<Integer>> astronaut) {
        // Build adjacency list representing connected astronauts (same country)
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> pair : astronaut) {
            adj.get(pair.get(0)).add(pair.get(1));
            adj.get(pair.get(1)).add(pair.get(0));
        }

        // Find connected components (countries) using DFS
        List<Integer> componentSizes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, adj, visited);
                componentSizes.add(size);
            }
        }

        // Calculate pairs from different countries
        int totalPairs = 0;
        int sum = 0;
        System.out.println("componentSizes "  + componentSizes);
        for (int size : componentSizes) {
            totalPairs += sum * size;
            sum += size;
        }

        return totalPairs;
    }

    private static int dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        int size = 1;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                size += dfs(v, adj, visited);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int n = 100000;
        List<List<Integer>> astronaut = new ArrayList<>();
        astronaut.add(Arrays.asList(1, 2));
        astronaut.add(Arrays.asList(3, 4));
        //astronaut.add(Arrays.asList(2, 3));
        //astronaut.add(Arrays.asList(0, 4));

        long result = astronautPairs(n, astronaut);
        System.out.println("Pairs from different countries: " + result); // Output: 6

        /*n = 4;
        astronaut = new ArrayList<>();
        astronaut.add(Arrays.asList(0,1));
        astronaut.add(Arrays.asList(2,3));

        result = astronautPairs(n, astronaut);
        System.out.println("Pairs from different countries: " + result); //Output 4

        n = 4;
        astronaut = new ArrayList<>();

        result = astronautPairs(n, astronaut);
        System.out.println("Pairs from different countries: " + result); //Output 6

        n = 5;
        astronaut = new ArrayList<>();
        astronaut.add(Arrays.asList(0,1));
        astronaut.add(Arrays.asList(0,2));
        astronaut.add(Arrays.asList(3,4));

        result = astronautPairs(n, astronaut);
        System.out.println("Pairs from different countries: " + result); //Output 6*/
    }
}