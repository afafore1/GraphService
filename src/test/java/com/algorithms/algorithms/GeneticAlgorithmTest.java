package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.algorithms.helper.TestHelper;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Ayomitunde on 3/25/2017.
 */
public class GeneticAlgorithmTest {
    @Test
    public void run() throws Exception {
//        Graph graph = TestHelper.createCompleteGraph(10);
//        Node startNode = graph.getNode(0);
//        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(graph, 10);
//        geneticAlgorithm.initializePopulation(startNode, graph.getNodeList());
//        int numberOfGenerations = 100;
//        for(int i = 0; i < numberOfGenerations; i++)
//        {
//            geneticAlgorithm.run();
//            System.out.println(geneticAlgorithm.getPathCost(geneticAlgorithm.getBestPath()));
//        }
         //Test with real states
        Graph graph = TestHelper.createStateGraph();
        System.out.println("Completed request and graph creation.");
        Node startNode = graph.getNode(0);
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(graph, 10);
        geneticAlgorithm.initializePopulation(startNode, graph.getNodeList());
        int numberOfGenerations = 100;
        for(int i = 0; i < numberOfGenerations; i++)
        {
            geneticAlgorithm.run();
            double cost = geneticAlgorithm.getPathCost(geneticAlgorithm.getBestPath());
            System.out.println("Current cost: "+cost);
        }
        ArrayList<Node> bestPath = geneticAlgorithm.getBestPath();
        System.out.println("Best path to take");
        //System.out.println(startNode.getValue());
        for(Node n : bestPath)
        {
            System.out.println(n.getValue());
        }
    }

}