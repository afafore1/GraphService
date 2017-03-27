package com.algorithms.algorithms;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ayomitunde on 3/25/2017.
 */
public class GeneticAlgorithm {
    private int populationSize;
    private HashMap<String, ArrayList<Node>> population;
    private Graph graph;
    private JsonArray report;
    public GeneticAlgorithm(Graph graph, int populationSize)
    {
        this.graph = graph;
        this.populationSize = populationSize;
        population = new HashMap<>();
        report = new JsonArray();
    }

    public void initializePopulation(Node startNode, ArrayList<Node> nodeList)
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
        JsonObject fitJson = new JsonObject();
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
        //fitJson.addProperty("fitness", fitness.toString());
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

    /*
    This method takes in a group of breeders (that is best groups in the population) and then
    uses them to create new children. The number of children reproduced will replace the worse groups.
     */
    private void breed(String[] breeders)
    {
        removeWorseGroups(breeders);
        for(int i = 0; i < breeders.length; i++)
        {
            String groupIdA = breeders[i];
            ArrayList<Node> groupA = population.get(groupIdA);
            int nextId = i+1;
            String groupIdB = nextId < breeders.length ? breeders[nextId] : breeders[0];
            ArrayList<Node> groupB = population.get(groupIdB);

            ArrayList<Node> newGroup = makeNewGroup(groupA, groupB);
            System.out.println("GroupA ->"); printList(groupA);
            System.out.println("GroupB ->"); printList(groupB);
            System.out.println("NewGroup ->"); printList(newGroup);
            replaceGroup(newGroup);
        }
    }

    private void replaceGroup(ArrayList<Node> newGroup)
    {
        for(String groupId : population.keySet())
        {
            if(population.get(groupId) == null)
            {
                population.put(groupId, newGroup);
                break;
            }
        }
    }
    private ArrayList<Node> makeNewGroup(ArrayList<Node> groupA, ArrayList<Node> groupB)
    {
        ArrayList<Node> formedGroupList;
        Node [] formedGroup = new Node[groupA.size()];
        int groupLen = groupA.size();
        for(int i = 0; i < groupLen; i++)
        {
            if(Math.random() < .5)
            {
                formedGroup[i] = groupA.get(i);
            }
        }

        for(int i = 0; i < groupLen; i++)
        {
            if(Arrays.asList(formedGroup).get(i) == null)
            {
                for(Node node : groupB)
                {
                    if(!Arrays.asList(formedGroup).contains(node))
                    {
                        formedGroup[i] = node;
                    }
                }
            }
        }
            formedGroupList = new ArrayList<>(Arrays.asList(formedGroup)); // recreating list all the time. refactor ?
        return formedGroupList;
    }

    private void removeWorseGroups(String [] breeders)
    {
        for(String groupId : population.keySet())
        {
            if(!Stream.of(breeders).anyMatch(x -> x == groupId)) // if this is not part of breeders set value to null
            {
                population.put(groupId, null);
            }
        }
    }

    public ArrayList<Node> getBestPath()
    {
        HashMap<String, Double> fitness = calculateFitness();
        String [] bestPath = fitness.entrySet().stream().sorted(HashMap.Entry.comparingByValue())
                .limit(1).collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue)).keySet().toArray(new String[1]);
        ArrayList<Node> bestPathList = population.get(bestPath[0]);
        printList(bestPathList);
        return bestPathList;
    }

    public void run()
    {
        HashMap<String, Double> fitness = calculateFitness();
        System.out.println(fitness);
        String [] breeders = getBreeders();
        breed(breeders);
        printPopulation();
    }

    void printPopulation()
    {
        for(String s : population.keySet())
        {
            ArrayList<Node> nodes = population.get(s);
            System.out.println(s+"------------------>");
            printList(nodes);
        }
    }

    void printList(ArrayList<Node> nodes)
    {
        for(Node node : nodes)
        {
            System.out.print(node.getId());
        }
        System.out.println();
    }
}
