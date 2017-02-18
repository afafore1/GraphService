package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Node;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ayomitunde on 2/18/2017.
 */
public class Dijkstra {
    private HashSet<Node> settledNodes;
    private HashMap<Node, Double> costToNode;
    private HashMap<Node, Double> costToUnsettledNodes;
    private HashSet<Node> allNodes;
    private HashSet<Edge> allEdges;
    Node source;
    Node destination;

    public Dijkstra(Node source, Node destination, HashSet<Node> allNodes, HashSet<Edge> allEdges)
    {
        this.source = source;
        this.destination = destination;
        settledNodes = new HashSet<>();
        costToNode = new HashMap<>();
        this.allNodes = allNodes;
        this.allEdges = allEdges;
        setAllWeightsToInfinity();
        run(source);
    }

    private void setAllWeightsToInfinity()
    {
        for(Node node : allNodes)
        {
            costToNode.put(node, Double.MAX_VALUE);
        }
        // set cost to initial node to 0
        costToNode.put(source, 0.0);
        costToUnsettledNodes = new HashMap<>(costToNode);
    }

    // There should be an easy/faster way to get edges
    private Edge getEdge(Node source, Node destination)
    {
        for(Edge edge : allEdges)
        {
            if(edge.getSource().equals(source) && edge.getDestination().equals(destination))
            {
                return edge;
            }
        }
        return null;
    }

    // should be replaced with min heap
    private Node getSmallestUnSettledNodeCost()
    {
        double minVal = Double.MIN_VALUE;
        for(Node node : costToUnsettledNodes.keySet())
        {
            double costToNode = costToUnsettledNodes.get(node);
            if(minVal > costToNode)
            {
                minVal = costToNode;
            }
        }

        for(Node node : costToUnsettledNodes.keySet())
        {
            if(costToUnsettledNodes.get(node) == minVal)
            {
                return node;
            }
        }
        return null;
    }

    public void run(Node current)
    {
        List<Object> currentsNeighbors = current.getNeighbors();
        for(Object obj : currentsNeighbors)
        {
            Node node = (Node) obj;
            if(!settledNodes.contains(node))
            {
                double costToCurrent = costToNode.get(current);
                Edge edgeBetweenNodes = getEdge(current, node);

                if(edgeBetweenNodes != null) // this should not happen!
                {
                    double costToCurrentsNeighbor = costToCurrent + edgeBetweenNodes.getWeight();
                    if(costToNode.get(node) > costToCurrentsNeighbor)
                    {
                        costToNode.put(node, costToCurrentsNeighbor);
                        node.setParent(current); // set it's parent to current node
                    }
                }

            }
        }
        // add to settled nodes
        settledNodes.add(current);
        costToUnsettledNodes.remove(current);
        // get node smallest cost that is not yet settled
        Node nextCurrent = getSmallestUnSettledNodeCost();
        if(nextCurrent.equals(destination))
        {
            // do nothing
        }
        else if(nextCurrent != null)
        {
            run(nextCurrent);
        }
        else
        {
            System.exit(1); // this should not happen. Perhaps, the graph is disconnected
        }
    }
}
