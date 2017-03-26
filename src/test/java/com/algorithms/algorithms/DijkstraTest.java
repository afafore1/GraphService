package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.algorithms.helper.TestHelper;
import org.junit.Test;

import java.util.ArrayList;
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
        Node source = graph.getNode(0);
        Node node1 = graph.getNode(1);
        Node node2 = graph.getNode(2);
        Node node3 = graph.getNode(3);
        Node node4 = graph.getNode(4);
        Node node5 = graph.getNode(5);
        Node node6 = graph.getNode(6);
        ArrayList<Node> nodeList = graph.getNodeList();
        HashSet<Object> nodeSet = new HashSet(nodeList);
        HashSet<Object> edgeSet  = new HashSet(graph.getEdgeList());

        Dijkstra dijkstra = new Dijkstra(source, node6, nodeSet, edgeSet);
        dijkstra.run(graph, source);
        assertTrue(source.getParent() == null);
        assertTrue(node1.getParent() == source);
        assertTrue(node2.getParent() == source);
        assertTrue(node3.getParent() == node1);
        assertTrue(node4.getParent() == source);
        assertTrue(node5.getParent() == node3);
        assertTrue(node6.getParent() == node4);
    }

}