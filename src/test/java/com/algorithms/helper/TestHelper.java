package com.algorithms.helper;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.google.gson.*;
import generators.Parser;
import helper.Requester;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Ayomitunde on 2/18/2017.
 */
public class TestHelper {
    static final String googleDistanceKey = "api-key"; //removing this since I'm pushing to public
    static String distanceMatrix = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=";
    public static Graph createGraph()
    {
        Graph graph = createGraphNodes(7);
        createNeighbors(graph);
        createEdges(graph);
        return graph;
    }

    public static Graph createCompleteGraph(int size)
    {
        Graph graph = createGraphNodes(size);
        createCompleteNeighbors(graph, size);
        return graph;
    }

    private static Graph createGraphNodes(int size)
    {
        Graph graph = new Graph();
        createNodes(size, graph);
        return graph;
    }

    private static File getFile(HashSet<File> fileSet, String filename)
    {
        for(File f : fileSet)
        {
            if(f.getName().equals(filename)) return f;
        }
        return null;
    }

    public static Graph createStateGraph()
    {
        Graph graph = new Graph();
        File stateFile = getFile(Parser.getDataFiles(), "States");
        try(Stream<String> stream = Files.lines(Paths.get(stateFile.getAbsolutePath())))
        {
            stream.forEach(new Consumer<String>() {
                int i = 0;
                @Override
                public void accept(String s) {
                    System.out.println(s);
                    graph.createNode(i++, s);
                }
            });
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        createCompleteStateNeighbors(graph, graph.getNodeList().size());
        return graph;
    }

    private static void createCompleteStateNeighbors(Graph graph, int size)
    {
        graph.isBidirectional();
        for(int i = 0; i < size; i++)
        {
            int [] neighbors = createNeighbors(i, size);
            graph.setNodeNeighbors(i, neighbors);
            for(int x : neighbors)
            {
                double weight = 0.0;
                Node source = graph.getNode(i);
                Node destination = graph.getNode(x);
                String link = distanceMatrix+source.getValue()+"&destinations="+destination.getValue()+"&key="+googleDistanceKey;
                URL distMatrix;
                try
                {
                    distMatrix = new URL(link);
                    String distanceMatrix = Requester.sendRequest(distMatrix);
                    JSONObject result = new JSONObject(distanceMatrix);
                    JSONArray row = result.getJSONArray ("rows");
                    JSONArray elements = ((JSONObject) row.get(0)).getJSONArray("elements");
                    JSONObject distance = elements.getJSONObject(0).getJSONObject("distance");
                    String distanceText = distance.getString("text");
                    distanceText = distanceText.substring(0, distanceText.indexOf("m")).replaceAll(",", "");
                    weight = Double.parseDouble(distanceText);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                graph.createEdge(source, destination, weight);
            }
        }
    }

    private static void createNodes(int numberOfNodes, Graph graph)
    {
        for(int i = 0; i < numberOfNodes; i++)
        {
            graph.createNode(i, null);
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
            int [] neighbors = createNeighbors(i, size);
            graph.setNodeNeighbors(i, neighbors);
            for(int x : neighbors)
            {
                graph.createEdge(graph.getNode(i), graph.getNode(x), (Math.random() * 120));
            }
        }
    }

    private static int []  createNeighbors(int currentNode, int size)
    {
        int[] neighbors = new int[size-1];
        int index = 0;
        for(int i = 0; i < size; i++)
        {
            if(i != currentNode) neighbors[index++] = i;
        }
        return neighbors;
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
