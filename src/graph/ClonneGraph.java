package graph;

import java.util.*;

public class ClonneGraph {

    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {

        if(node == null)
            return node;

        Node clone = new Node();
        clone.val = node.val;
        map.put(node,clone);
        List<Node> neighbours = node.neighbors;

        for(Node neighbour : neighbours)
        {
            if(!map.containsKey(neighbour))
            {
                clone.neighbors.add(cloneGraph(neighbour));

            }else {
                clone.neighbors.add(map.get(neighbour));
            }
        }
        return clone;
    }
}
