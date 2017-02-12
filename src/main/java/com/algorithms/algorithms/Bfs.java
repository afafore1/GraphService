package com.algorithms.algorithms;

import com.algorithms.graph.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Ayomitunde on 2/11/2017.
 */
public class Bfs {
    private Node source;
    public Bfs(Node source)
    {
        this.source = source;
    }

    public void run()
    {
        Queue<Node> nodeQueue = new LinkedList<>();
        source.setVisited(true);
        source.setParent(source);
        nodeQueue.add(source);
        while(!nodeQueue.isEmpty())
        {
            Node current = nodeQueue.remove();
            List<Node> currentsNeighbors = (List<Node>)(Object) current.getNeighbors();
            for(Node node : currentsNeighbors)
            {
                if(!node.getVisited())
                {
                    node.setVisited(true);
                    node.setParent(current);
                    nodeQueue.add(node);
                }
            }
        }
    }
}
