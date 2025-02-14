package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {

    @Override
    public String toString() {
        return "val=" + val ;

    }

    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static Node createSampleGraph()
    {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        Node node7 = new Node(7);

        // Define neighbors (create the graph structure)
        node0.neighbors.add(node2);
        node0.neighbors.add(node3);
        node0.neighbors.add(node5);
        node2.neighbors.add(node1);
        node3.neighbors.add(node4);
        node5.neighbors.add(node7);
        return node0;
    }

    public static void printGraph(Node startNode) {
        Map<Node, Boolean> visited = new HashMap<>(); // Keep track of visited nodes to avoid cycles
        printGraphRecursive(startNode, visited);
    }


    private static void printGraphRecursive(Node node, Map<Node, Boolean> visited) {
        if (node == null || visited.getOrDefault(node, false)) {
            return; // Already visited or null
        }

        visited.put(node, true);
        System.out.print("Node " + node.val + ": ");

        if (!node.neighbors.isEmpty()) {
            System.out.print("Neighbors: ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.val + " ");
            }
        } else {
            System.out.print("No neighbors");
        }
        System.out.println();

        // Recursively print neighbors (depth-first traversal)
        for (Node neighbor : node.neighbors) {
            printGraphRecursive(neighbor, visited);
        }
    }
}
