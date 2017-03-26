package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.algorithms.helper.TestHelper;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ayomitunde on 2/12/2017.
 */
public class BfsTest {
    @org.junit.Test
    public void run() throws Exception {
        Graph graph = TestHelper.createGraph();
        Node source = graph.getNode(0);
        Node node1 = graph.getNode(1);
        Node node2 = graph.getNode(2);
        Node node3 = graph.getNode(3);
        Node node4 = graph.getNode(4);
        Node node5 = graph.getNode(5);
        Node node6 = graph.getNode(6);
        Bfs bfs = new Bfs(source);
        bfs.run();
        assertTrue(source.getParent() == source);
        assertTrue(node1.getParent() == source);
        assertTrue(node2.getParent() == source);
        assertTrue(node3.getParent() == node1);
        assertTrue(node4.getParent() == source);
        assertTrue(node5.getParent() == node3);
        assertTrue(node6.getParent() == node4);
        assertTrue(node6.getVisited() == true);

    }

}