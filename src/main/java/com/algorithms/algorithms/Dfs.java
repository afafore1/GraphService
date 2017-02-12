package com.algorithms.algorithms;

import com.algorithms.graph.Node;

import java.util.List;
import java.util.Stack;

/**
 * Created by Ayomitunde on 2/11/2017.
 */
public class Dfs {
    private Node source;
    public Dfs(Node source)
    {
        this.source = source;
    }

    public void run()
    {
        Stack<Node> nodeStack = new Stack<>();
        source.setVisited(true);
        source.setParent(source);
        nodeStack.push(source);
        while(!nodeStack.isEmpty())
        {
            Node current = nodeStack.peek();
            List<Node> currentsNeighbors = (List<Node>)(Object) current.getNeighbors();
            if(currentsNeighbors.isEmpty() || areAllNeighborsVisted(current))
            {
                nodeStack.pop();
                continue;
            }
            for(Node node : currentsNeighbors)
            {
                if(!node.getVisited())
                {
                    nodeStack.push(node);
                    node.setParent(current);
                    node.setVisited(true);
                    break;
                }
            }
        }
    }

    private boolean areAllNeighborsVisted(Node node)
    {
        List<Node> currentsNeighbors = (List<Node>)(Object) node.getNeighbors();
        for(Node n : currentsNeighbors)
        {
            if(!n.getVisited()) return false;
        }
        return true;
    }
}
