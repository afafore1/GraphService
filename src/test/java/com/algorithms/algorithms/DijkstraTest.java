package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Node;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ayomitunde on 2/18/2017.
 */
public class DijkstraTest {
    @Test
    public void run() throws Exception {
        HashMap<Integer, Node> allNodes = TestHelper.createNodeMap();
        Node source = allNodes.get(1);
        Node node2 = allNodes.get(2);
        Node node3 = allNodes.get(3);
        Node node4 = allNodes.get(4);
        Node node5 = allNodes.get(5);
        Node node6 = allNodes.get(6);
        Node node7 = allNodes.get(7);
        HashMap<Integer, Node> nodeHashMap = TestHelper.createNodeMap();
        List<Object> nodeList = TestHelper.createNodeList(nodeHashMap);
        HashSet<Node> nodeSet = new HashSet(nodeList);
        HashSet<Edge> edgeSet  = new HashSet(TestHelper.createEdgeList(nodeList));

        Dijkstra dijkstra = new Dijkstra(source, node6, nodeSet, edgeSet);
        dijkstra.run(source);
        assertTrue(source.getParent() == source);
        assertTrue(node2.getParent() == source);
        assertTrue(node3.getParent() == source);
        assertTrue(node4.getParent() == node2);
        assertTrue(node5.getParent() == source);
        assertTrue(node6.getParent() == node4);
        assertTrue(node7.getParent() == node6);
    }

}