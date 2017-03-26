package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.algorithms.helper.TestHelper;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ayomitunde on 3/25/2017.
 */
public class GeneticAlgorithmTest {
    @Test
    public void run() throws Exception {
        Graph graph = TestHelper.createCompletGraph(10);
        Node startNode = graph.getNode(0);
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(graph, startNode, 10);
        geneticAlgorithm.run();
    }

}