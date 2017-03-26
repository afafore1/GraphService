package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ayomitunde on 3/25/2017.
 */
public class GeneticAlgorithm {
    private int populationSize;
    private Node startNode;
    private HashMap<String, ArrayList<Node>> population;
    private Graph graph;
    public GeneticAlgorithm(Graph graph, Node startNode, int populationSize)
    {
        this.graph = graph;
        this.populationSize = populationSize;
        this.startNode = startNode;
        population = new HashMap<>();
    }

    private void populate(ArrayList<Node> nodeList)
    {
        // remove the startNode
        nodeList.remove(startNode);
        Random r = new Random(7237762);
        for(int i = 0; i < populationSize; i++)
        {
            String populationId = String.valueOf(i);
            ArrayList<Node> nodeCopy = new ArrayList<>(nodeList);
            Collections.shuffle(nodeCopy, r);
            nodeCopy.add(0, startNode);
            population.put(populationId, nodeCopy);
        }
    }

    private HashMap<String, Double> calculateFitness()
    {
        HashMap<String, Double> fitness = new HashMap<>();
        for(String populationId : population.keySet())
        {
            ArrayList<Node> group = population.get(populationId);
            double groupWeight = 0.0;
            for(int i = 0; i < group.size(); i++)
            {
                Node source = group.get(i);
                int next = i+1;
                Node dest = next < group.size() ? group.get(next) : group.get(0);
                Edge connectingEdge = graph.getEdge(source, dest);
                groupWeight += connectingEdge.getWeight();
            }
            fitness.put(populationId, groupWeight);
        }
        return fitness;
    }

    private String [] getBreeders()
    {
        HashMap<String, Double> fitness = calculateFitness();
        int breederSize = fitness.size() / 2;
        String [] breeders = fitness.entrySet().stream().sorted(HashMap.Entry.comparingByValue())
                .limit(breederSize).collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue)).keySet().toArray(new String[breederSize]);
        return breeders;
    }

    private void breed()
    {

    }


    public void run()
    {
        populate(graph.getNodeList());
        HashMap<String, Double> fitness = calculateFitness();
        System.out.println(fitness);
        String [] breeders = getBreeders();
        System.out.println(Arrays.toString(breeders));
        printPopulation();
    }

    void printPopulation()
    {
        for(String s : population.keySet())
        {
            ArrayList<Node> nodes = population.get(s);
            System.out.println(s+"------------------>");
            for(Node node : nodes)
            {
                System.out.print(node.getId());
            }
            System.out.println();
        }
    }
}
