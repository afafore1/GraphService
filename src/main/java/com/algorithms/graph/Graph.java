
package com.algorithms.graph;

import com.algorithms.algorithms.Algos;

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

    public void createNode(int id, String value)
    {
        if(!nodeHashMap.containsKey(id))
        {
            Node node = new Node();
            node.setId(id);
            if(value == null)
            {
                node.setValue(String.valueOf(id));
            }else
            {
                node.setValue(value);
            }
            node.setVisited(false);
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

    public HashMap<Node, Node> getShortestPath(Node sourceNode, Node destinationNode)
    {
        HashMap<Node, Node> shortestPath = new HashMap<>();
        Node parent = (Node)destinationNode.getParent();
        shortestPath.put(parent, destinationNode);
        while(parent != sourceNode)
        {
            shortestPath.put(parent, (Node) parent.getParent());
        }
        return shortestPath;
    }

    public boolean isComplete() {
        return Algos.isComplete(this);
    }

    public boolean isBipartite() {
        return Algos.isBipartite(this);
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