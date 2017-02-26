package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Node;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Ayomitunde on 2/19/2017.
 */
public class MinHeap
{
    private static double min = Double.MAX_VALUE;
    private static Vertex nextVertex = null;
    private static HashMap<Vertex, Double> allVertices;

    MinHeap()
    {
        allVertices = new HashMap<>();
    }

    protected static void insert(double value)
    {
        Vertex vertex = new Vertex(value);

    }


    protected static double getMin()
    {
        return min;
    }
}

class Vertex
{
    private double value;
    private Vertex parent;
    private int id; // this id will match nodeId
    private Vertex[] children;

    Vertex(int id, double value)
    {
        this.id = id;
        this.value = value;
        children = new Vertex[2];
    }

    Vertex(double value)
    {
        this.value = value;

    }

    protected void setChild(Vertex child)
    {
        if(children[0] != null)
        {
            children[0] = child;
        }else
        {
            children[1] = child;
        }
    }




    protected int getId()
    {
        return this.id;
    }

    protected double getValue()
    {
        return value;
    }
    protected Vertex getParent()
    {
        return parent;
    }

    protected void setParent(Vertex p)
    {
        parent = p;
    }

}