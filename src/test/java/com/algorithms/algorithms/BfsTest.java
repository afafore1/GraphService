package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ayomitunde on 2/12/2017.
 */
public class BfsTest {
    @org.junit.Test
    public void run() throws Exception {
        Graph graph = new Graph();
        HashMap<Integer, Node> allNodes = TestHelper.createNodeMap();
        Node source = allNodes.get(1);
        Node node2 = allNodes.get(2);
        Node node3 = allNodes.get(3);
        Node node4 = allNodes.get(4);
        Node node5 = allNodes.get(5);
        Node node6 = allNodes.get(6);
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