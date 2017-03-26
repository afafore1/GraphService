package com.algorithms.helper;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import generators.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ayomitunde on 2/18/2017.
 */
public class TestHelper {

    public static Graph createGraph()
    {
        Graph graph = new Graph();
        createNodes(7, graph); // passing object is by reference
        createNeighbors(graph);
        createEdges(graph);
        return graph;
    }

    private static void createNodes(int numberOfNodes, Graph graph)
    {
        for(int i = 0; i < numberOfNodes; i++)
        {
            graph.createNode(i);
        }
    }

    private static void createNeighbors(Graph graph)
    {
        graph.isBidirectional();
        graph.setNodeNeighbors(0, 1,2,4);
        graph.setNodeNeighbors(1, 2,3);
        graph.setNodeNeighbors(2, 3,4);
        graph.setNodeNeighbors(3, 4,5,6);
        graph.setNodeNeighbors(4, 6);
        graph.setNodeNeighbors(5, 6);
    }

    private static void createEdges(Graph graph)
    {
        graph.createEdge(graph.getNode(0), graph.getNode(1), 4.0);
        graph.createEdge(graph.getNode(0), graph.getNode(2), 3.0);
        graph.createEdge(graph.getNode(0), graph.getNode(4), 7.0);
        graph.createEdge(graph.getNode(1), graph.getNode(2), 6.0);
        graph.createEdge(graph.getNode(1), graph.getNode(3), 5.0);
        graph.createEdge(graph.getNode(2), graph.getNode(3), 11.0);
        graph.createEdge(graph.getNode(2), graph.getNode(4), 8.0);
        graph.createEdge(graph.getNode(3), graph.getNode(4), 2.0);
        graph.createEdge(graph.getNode(3), graph.getNode(6), 10.0);
        graph.createEdge(graph.getNode(3), graph.getNode(5), 2.0);
        graph.createEdge(graph.getNode(4), graph.getNode(6), 5.0);
        graph.createEdge(graph.getNode(5), graph.getNode(6), 3.0);
    }

//    private static ArrayList<Edge> createEdgeList(HashMap<Integer, Node> nodeHashMap)
//    {
//        //this can be done while adding neighbors no ? I'm lazy !! But this is even longer !!!! ok, refactor later.. why am I commenting to myself ?
//        ArrayList<Edge> edgeList;
//        Node node1 = nodeHashMap.get(1);
//        Node node2 = nodeHashMap.get(2);
//        Node node3 = nodeHashMap.get(3);
//        Node node4 = nodeHashMap.get(4);
//        Node node5 = nodeHashMap.get(5);
//        Node node6 = nodeHashMap.get(6);
//        Node node7 = nodeHashMap.get(7);
//        Edge edge1 = createEdge(node1, node2, 4.0);
//        Edge edge2 = createEdge(node1, node3, 3.0);
//        Edge edge3 = createEdge(node1, node5, 7.0);
//        Edge edge4 = createEdge(node2, node3, 6.0);
//        Edge edge5 = createEdge(node2, node4, 5.0);
//        Edge edge6 = createEdge(node3, node4, 11.0);
//        Edge edge7 = createEdge(node3, node5, 8.0);
//        Edge edge8 = createEdge(node4, node5, 2.0);
//        Edge edge9 = createEdge(node4, node7, 10.0);
//        Edge edge10 = createEdge(node4, node6, 2.0);
//        Edge edge11 = createEdge(node5, node7, 5.0);
//        Edge edge12 = createEdge(node6, node7, 3.0);
//        edgeList = addAllEdges(edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11, edge12);
//        return edgeList;
//    }

//    private static ArrayList<Edge> addAllEdges(Edge ... edges)
//    {
//        ArrayList<Edge> edgeList = new ArrayList<>();
//        for(Edge edge : edges)
//        {
//            edgeList.add(edge);
//        }
//        return edgeList;
//    }

//    private static ArrayList<Node> createNodeList(HashMap<Integer, Node> nodeMap)
//    {
//        ArrayList<Node> nodeList = new ArrayList<>();
//        for(Integer nodeId : nodeMap.keySet())
//        {
//            nodeList.add(nodeMap.get(nodeId));
//        }
//        return nodeList;
//    }

//    private static Edge createEdge(Node source, Node destination, double weight)
//    {
//        Edge edge = new Edge();
//        edge.setSource(source);
//        edge.setDestination(destination);
//        edge.setWeight(weight);
//        edge.setIsSettled(false);
//        return edge;
//    }

//    private static Node createNode(int id)
//    {
//        Node node = new Node();
//        node.setId(id);
//        node.setVisited(false);
//        node.setXPosition((int)Math.random());
//        node.setYPosition((int)Math.random());
//        node.setParent(null); // initially set to null
//        return node;
//    }

//    private static List<Object> createNodeNeighbors(Object ... nodes)
//    {
//        List<Object> neighbors = new LinkedList<>();
//        for(Object node : nodes)
//        {
//            neighbors.add(node);
//        }
//        return neighbors;
//    }

//    private static HashMap<Integer, Node> addAllNodesToMap(Node ... nodes)
//    {
//        HashMap<Integer, Node> nodeMap = new HashMap<>();
//        for(Node node : nodes)
//        {
//            nodeMap.put(node.getId(), node);
//        }
//        return nodeMap;
//    }

//    public static HashMap<Integer, Node> createNodeMap()
//    {
//        HashMap<Integer, Node> nodeMap;
//        Node node1 = createNode(1);
//        Node node2 = createNode(2);
//        Node node3 = createNode(3);
//        Node node4 = createNode(4);
//        Node node5 = createNode(5);
//        Node node6 = createNode(6);
//        Node node7 = createNode(7);
//        List<Object> node1Neighbors = createNodeNeighbors(node2, node3, node5);
//        node1.setNeighbors(node1Neighbors);
//        List<Object> node2Neighbors = createNodeNeighbors(node1, node3, node4);
//        node2.setNeighbors(node2Neighbors);
//        List<Object> node3Neighbors = createNodeNeighbors(node1, node2, node4, node5);
//        node3.setNeighbors(node3Neighbors);
//        List<Object> node4Neighbors = createNodeNeighbors(node2, node3, node5, node6, node7);
//        node4.setNeighbors(node4Neighbors);
//        List<Object> node5Neighbors = createNodeNeighbors(node1, node3, node4, node7);
//        node5.setNeighbors(node5Neighbors);
//        List<Object> node6Neighbors = createNodeNeighbors(node4, node7);
//        node6.setNeighbors(node6Neighbors);
//        List<Object> node7Neighbors = createNodeNeighbors(node4, node5, node6);
//        node7.setNeighbors(node7Neighbors);
//        nodeMap = addAllNodesToMap(node1, node2, node3, node4, node5, node6, node7);
//
//        return nodeMap;
//    }
}
