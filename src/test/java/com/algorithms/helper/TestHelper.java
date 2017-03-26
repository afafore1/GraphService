package com.algorithms.helper;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import generators.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

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

    public static Graph createCompletGraph(int size)
    {
        Graph graph = new Graph();
        createNodes(size, graph);
        createCompleteNeighbors(graph, size);
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

    private static void createCompleteNeighbors(Graph graph, int size)
    {
        graph.isBidirectional();
        for(int i = 0; i < size; i++)
        {
            int [] neighbors = new int[size];
            IntStream.range(0, size).forEach(val -> neighbors[val] = val);
            for(int x : neighbors)
            {
                if(x != i)
                {
                    graph.setNodeNeighbors(x, neighbors);
                    graph.createEdge(graph.getNode(i), graph.getNode(x), (Math.random() * 120));
                }
            }
        }
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
}
