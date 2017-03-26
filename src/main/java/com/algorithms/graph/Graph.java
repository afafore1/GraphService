
package com.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Graph
 * <p>
 * 
 * 
 */
public class Graph
{
    private HashMap<Integer, Node> nodeHashMap;
    private HashMap<String, Edge> edgeHashMap;
    private boolean isBidirectional = false;
    public Graph()
    {
        nodeHashMap = new HashMap<>();
        edgeHashMap = new HashMap<>();
    }

    public void isBidirectional()
    {
        isBidirectional = true;
    }

    public void createNode(int id)
    {
        if(!nodeHashMap.containsKey(id))
        {
            Node node = new Node();
            node.setId(id);
            node.setVisited(false);
            node.setXPosition((int)Math.random());
            node.setYPosition((int)Math.random());
            node.setParent(null); // initially set to null
            nodeHashMap.put(id, node);
        }
    }

    public void removeNode(int id)
    {
        nodeHashMap.remove(id);
    }

    public Node getNode(int id)
    {
        return nodeHashMap.get(id);
    }

    public void setNodeNeighbors(int id, int ... ints)
    {
        Node currentNode = nodeHashMap.get(id);
        for(int x : ints)
        {
            Node neighbor = nodeHashMap.get(x);
            currentNode.getNeighbors().add(neighbor);
            if(isBidirectional)
            {
                if(!neighbor.getNeighbors().contains(currentNode))
                {
                    neighbor.getNeighbors().add(currentNode);
                }
            }
        }
    }

    public void createEdge(Node source, Node destination, double weight)
    {
        Edge edge = new Edge();
        edge.setSource(source);
        edge.setDestination(destination);
        edge.setWeight(weight);
        edge.setIsSettled(false);
        String edgeId = ""+source.getId()+""+destination.getId();
        edge.setId(Integer.parseInt(edgeId));
        edgeHashMap.put(edgeId, edge);
    }

    public void removeEdge(String edgeId)
    {
        edgeHashMap.remove(edgeId);
    }

    public Edge getEdge(Node source, Node destination)
    {
        String edgeId = ""+source.getId()+""+destination.getId();
        return edgeHashMap.get(edgeId);
    }

    public ArrayList<Node> getNodeList()
    {
        ArrayList<Node> allNodes =  new ArrayList<>();
        allNodes.addAll(nodeHashMap.values());
        return allNodes;
    }

    public ArrayList<Edge> getEdgeList()
    {
        ArrayList<Edge> allEdges = new ArrayList<>();
        allEdges.addAll(edgeHashMap.values());
        return allEdges;
    }

    public ArrayList<Node> getShortestPath(Node sourceNode, Node destinationNode)
    {
        ArrayList<Node> shortestPath = new ArrayList<>();
        Node parent = (Node)destinationNode.getParent();
        shortestPath.add(destinationNode);
        shortestPath.add(parent);
        while(parent != sourceNode)
        {
            parent = (Node)parent.getParent();
            shortestPath.add(parent);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    public ArrayList<Integer> printShortestPath(ArrayList<Node> shortestPath)
    {
        ArrayList<Integer> path = new ArrayList<>();
        for(Node node : shortestPath)
        {
            path.add(node.getId());
        }
        return path;
    }
}