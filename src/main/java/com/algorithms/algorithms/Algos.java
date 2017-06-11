package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;

import java.util.*;

/**
 * Created by ayomitundefafore on 6/4/17.
 */
public class Algos {
    public static boolean isBipartite(Graph graph) {
        List<Node> allNodes = graph.getNodeList();
        Node source = allNodes.get(0);
        Queue<Node> nodeQueue = new LinkedList<>();
        Map<Node, String> nodeColoringMap = new HashMap<>();
        nodeColoringMap.put(source, "B");
        nodeQueue.add(source);
        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.remove();
            if (!current.getVisited()) {
                current.setVisited(true);
                List<Node> neighbors = (List<Node>) (Object) current.getNeighbors();
                for (Node node : neighbors) {
                    if (nodeColoringMap.get(node) != null) {
                        if (nodeColoringMap.get(node) == nodeColoringMap.get(current)) {
                            return false;
                        }
                    } else {
                        String color = nodeColoringMap.get(current) == "B" ? "R" : "B";
                        nodeColoringMap.put(node, color);
                    }
                    nodeQueue.add(node);
                }
            }
        }
        return true;
    }

    public static boolean isComplete(Graph graph) {
        List<Node> allNodes = graph.getNodeList();
        Node source = allNodes.get(0);
        //run bfs and see if we can reach all Nodes
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(source);
        //source.setVisited(true);
        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.remove();
            if (!current.getVisited()) {
                current.setVisited(true);
                List<Node> neighbors = (List<Node>) (Object) current.getNeighbors();
                neighbors.stream()
                        .filter(n -> !n.getVisited())
                        .forEach(n -> {
                            nodeQueue.add(n);
                            n.setVisited(true);
                        });
            }
        }
        for (Node n : allNodes) {
            if (!n.getVisited()) {
                return  false;
            }
        }
        return true;
    }

    public static boolean cutExist(Graph graph) {
        return false;
    }
}
