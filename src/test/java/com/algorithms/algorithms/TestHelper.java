package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ayomitunde on 2/18/2017.
 */
class TestHelper {
    protected static Graph createGraph()
    {
        Graph graph = new Graph();
        HashMap<Integer, Node> nodeMap = createNodeMap();
        List<Object> nodeList = createNodeList(nodeMap);
        List<Object> edgeList = createEdgeList(nodeList);
        graph.setNodeList(nodeList);
        graph.setEdgeList(edgeList);
        return graph;
    }

    protected static List<Object> createEdgeList(List<Object> nodeList)
    {
        List<Object> edgeList = new LinkedList<>();

        return edgeList;
    }

    private static List<Object> createNodeList(HashMap<Integer, Node> nodeMap)
    {
        List<Object> nodeList = new LinkedList<>();
        for(Integer nodeId : nodeMap.keySet())
        {
            nodeList.add(nodeMap.get(nodeId));
        }
        return nodeList;
    }
    private Edge createEdge(Node source, Node destination, double weight)
    {
        Edge edge = new Edge();
        edge.setSource(source);
        edge.setDestination(destination);
        edge.setWeight(weight);
        edge.setIsSettled(false);
        return edge;
    }

    private static Node createNode(int id)
    {
        Node node = new Node();
        node.setId(id);
        node.setVisited(false);
        return node;
    }

    private static List<Object> createNodeNeighbors(Node ... nodes)
    {
        List<Object> neighbors = new LinkedList<>();
        for(Node node : nodes)
        {
            neighbors.add(node);
        }
        return neighbors;
    }

    private static HashMap<Integer, Node> addAllNodesToMap(Node ... nodes)
    {
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for(Node node : nodes)
        {
            nodeMap.put(node.getId(), node);
        }
        return nodeMap;
    }

    protected static HashMap<Integer, Node> createNodeMap()
    {
        HashMap<Integer, Node> nodeMap;
        Node node1 = createNode(1);
        Node node2 = createNode(2);
        Node node3 = createNode(3);
        Node node4 = createNode(4);
        Node node5 = createNode(5);
        Node node6 = createNode(6);
        Node node7 = createNode(7);
        List<Object> node1Neighbors = createNodeNeighbors(node2, node3, node5);
        node1.setNeighbors(node1Neighbors);
        List<Object> node2Neighbors = createNodeNeighbors(node1, node3, node4);
        node2.setNeighbors(node2Neighbors);
        List<Object> node3Neighbors = createNodeNeighbors(node1, node2, node4, node5);
        node3.setNeighbors(node3Neighbors);
        List<Object> node4Neighbors = createNodeNeighbors(node2, node3, node5, node6, node7);
        node4.setNeighbors(node4Neighbors);
        List<Object> node5Neighbors = createNodeNeighbors(node1, node3, node4, node7);
        node5.setNeighbors(node5Neighbors);
        List<Object> node6Neighbors = createNodeNeighbors(node4, node7);
        node6.setNeighbors(node6Neighbors);
        List<Object> node7Neighbors = createNodeNeighbors(node4, node5, node6);
        node7.setNeighbors(node7Neighbors);
        nodeMap = addAllNodesToMap(node1, node2, node3, node4, node5, node6, node7);

        return nodeMap;
    }
}
