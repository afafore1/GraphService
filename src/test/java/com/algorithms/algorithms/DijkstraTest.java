package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.algorithms.helper.TestHelper;
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
        Graph graph = TestHelper.createGraph();
        HashMap<Integer, Node> nodeHashMap = TestHelper.createNodeMap();
        Node source = nodeHashMap.get(1);
        Node node2 = nodeHashMap.get(2);
        Node node3 = nodeHashMap.get(3);
        Node node4 = nodeHashMap.get(4);
        Node node5 = nodeHashMap.get(5);
        Node node6 = nodeHashMap.get(6);
        Node node7 = nodeHashMap.get(7);
        List<Object> nodeList = graph.getNodeList();
        HashSet<Node> nodeSet = new HashSet(nodeList);
        HashSet<Edge> edgeSet  = new HashSet(graph.getEdgeList());

        Dijkstra dijkstra = new Dijkstra(source, node6, nodeSet, edgeSet);
        dijkstra.run(source);
        assertTrue(source.getParent() == source);
        assertTrue(node2.getParent() == source);
        assertTrue(node3.getParent() == source);
        assertTrue(node4.getParent() == node2);
        assertTrue(node5.getParent() == source);
        assertTrue(node6.getParent() == node4);
        assertTrue(node7.getParent() == node5);
    }

}