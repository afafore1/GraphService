package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ayomitunde on 2/12/2017.
 */
public class BfsTest {
    private List<Object> createNodeList()
    {
        List<Object> nodeList = new LinkedList<>();
        Node node1 = new Node();
        node1.setId(1);
        node1.setVisited(false);
        Node node2 = new Node();
        node2.setId(2);
        node2.setVisited(false);
        Node node3 = new Node();
        node3.setId(3);
        node3.setVisited(false);
        Node node4 = new Node();
        node4.setId(4);
        node4.setVisited(false);
        Node node5 = new Node();
        node5.setId(5);
        node5.setVisited(false);
        Node node6 = new Node();
        node6.setId(6);
        node6.setVisited(false);
        List<Object> node1Neighbors = new LinkedList<>();
        node1Neighbors.add(node2);
        node1Neighbors.add(node3);
        node1Neighbors.add(node5);
        node1.setNeighbors(node1Neighbors);
        List<Object> node2Neighbors = new LinkedList<>();
        node2Neighbors.add(node1);
        node2Neighbors.add(node4);
        node2.setNeighbors(node2Neighbors);
        List<Object> node3Neighbors = new LinkedList<>();
        node3Neighbors.add(node1);
        node3Neighbors.add(node4);
        node3.setNeighbors(node3Neighbors);
        List<Object> node4Neighbors = new LinkedList<>();
        node4Neighbors.add(node2);
        node4Neighbors.add(node6);
        node4.setNeighbors(node4Neighbors);
        List<Object> node5Neighbors = new LinkedList<>();
        node5Neighbors.add(node1);
        node5Neighbors.add(node3);
        node5.setNeighbors(node5Neighbors);
        List<Object> node6Neighbors = new LinkedList<>();
        node6Neighbors.add(node4);
        node6.setNeighbors(node6Neighbors);
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);

        return nodeList;
    }

    private Node getNodeWithId(int nodeId, List<Object> nodeList)
    {
        for(Object obj : nodeList)
        {
            Node node = (Node) obj;
            if(node.getId() == nodeId) return node;
        }
        return null;
    }

    @org.junit.Test
    public void run() throws Exception {
        Graph graph = new Graph();
        List<Object> allNodes = createNodeList();
        graph.setNodeList(allNodes);
        Node source = getNodeWithId(1, allNodes);
        Node node2 = getNodeWithId(2, allNodes);
        Node node3 = getNodeWithId(3, allNodes);
        Node node4 = getNodeWithId(4, allNodes);
        Node node5 = getNodeWithId(5, allNodes);
        Node node6 = getNodeWithId(6, allNodes);
        Bfs bfs = new Bfs(source);
        bfs.run();
        assertTrue(source.getParent() == source);
        assertTrue(node2.getParent() == source);
        assertTrue(node3.getParent() == source);
        assertTrue(node4.getParent() == node2);
        assertTrue(node5.getParent() == source);
        assertTrue(node6.getParent() == node4);
        assertTrue(node6.getVisited() == true);

    }

}