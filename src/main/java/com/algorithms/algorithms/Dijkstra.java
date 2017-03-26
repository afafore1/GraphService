package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ayomitunde on 2/18/2017.
 */
public class Dijkstra {
    private HashSet<Node> settledNodes;
    private HashMap<Node, Double> costToUnsettledNodes;
    private HashSet<Object> allNodes;
    private HashSet<Object> allEdges;
    Node source;
    Node destination;

    public Dijkstra(Node source, Node destination, HashSet<Object> allNodes, HashSet<Object> allEdges)
    {
        this.source = source;
        this.destination = destination;
        settledNodes = new HashSet<>();
        this.allNodes = allNodes;
        this.allEdges = allEdges;
        costToUnsettledNodes = new HashMap<>();
        initializeNodes();
    }

    /*
    Set all node parents to null.
    Source Node parent is itself, and cost to source is 0 since it's start position
    All other node cost should be infinity.
     */
    private void initializeNodes()
    {
        for(Object object : allNodes)
        {
            Node node = (Node)object;
            costToUnsettledNodes.put(node, Double.MAX_VALUE);
            node.setParent(null);
        }
        // set cost to initial node to 0
        costToUnsettledNodes.put(source, 0.0);
        source.setParent(null); // the source doesn't have a parent since we start from that. This is also to avoid stackoverflow exception
    }

    // should be replaced with min heap
    private Node getSmallestUnSettledNodeCost()
    {
        double minVal = Double.MAX_VALUE;
        Node minNode = null;
        for(Node node : costToUnsettledNodes.keySet())
        {
            double costToNode = costToUnsettledNodes.get(node);
            if(minVal > costToNode)
            {
                minVal = costToNode;
                minNode = node;
            }
        }

        return minNode;
    }

    public void run(Graph graph, Node current)
    {
        List<Object> currentsNeighbors = current.getNeighbors();
        for(Object obj : currentsNeighbors)
        {
            Node node = (Node) obj;
            if(!settledNodes.contains(node))
            {
                double costToCurrent = costToUnsettledNodes.get(current);
                Edge edgeBetweenNodes = graph.getEdge(current, node);

                if(edgeBetweenNodes != null) // this should not happen!
                {
                    double costToCurrentsNeighbor = costToCurrent + edgeBetweenNodes.getWeight();
                    if(costToUnsettledNodes.containsKey(node))
                    {
                        if(costToUnsettledNodes.get(node) > costToCurrentsNeighbor)
                        {
                            costToUnsettledNodes.put(node, costToCurrentsNeighbor);
                            node.setParent(current); // set it's parent to current node
                        }
                    }
                }

            }
        }
        // add to settled nodes
        settledNodes.add(current);
        costToUnsettledNodes.remove(current);

        // We are done if all nodes are settled.
        if(costToUnsettledNodes.isEmpty())
        {
            System.out.println("Algorithm is done running!"); // done, print path ?
        }
        else
        {
            // get node smallest cost that is not yet settled
            Node nextCurrent = getSmallestUnSettledNodeCost();
            if(nextCurrent.equals(destination))
            {
                // do nothing
            }
            else if(nextCurrent != null)
            {
                run(graph, nextCurrent);
            }
        }
    }
}
