package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.algorithms.helper.TestHelper;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ayomitundefafore on 6/9/17.
 */
public class AlgosTest {
    @Test
    public void isBipartite() throws Exception {
        Graph graph = TestHelper.createGraph();
        assert graph.isBipartite() == false : "graph is not bipartite but returned true";
    }

    @Test
    public void isComplete() throws Exception {
        Graph graph = TestHelper.createGraph();
        Node source = graph.getNode(0);
        Node node1 = graph.getNode(1);
        Node node2 = graph.getNode(2);
        Node node3 = graph.getNode(3);
        Node node4 = graph.getNode(4);
        Node node5 = graph.getNode(5);
        Node node6 = graph.getNode(6);
        assert graph.isComplete() == false : "graph should be incomplete";
        graph = TestHelper.createCompleteGraph(10);
        assert graph.isComplete() : "graph should be complete";
    }

}