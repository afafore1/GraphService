package algorithms;

import com.algorithms.algorithms.Bfs;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;

import javax.validation.constraints.AssertTrue;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ayomitunde on 2/11/2017.
 */
public class BfsTest {
    private List<Object> createNodeList()
    {
        List<Object> nodeList = new LinkedList<>();
        Node node1 = new Node();
        node1.setId(1);
        Node node2 = new Node();
        node1.setId(2);
        Node node3 = new Node();
        node1.setId(3);
        Node node4 = new Node();
        node1.setId(4);
        Node node5 = new Node();
        node1.setId(5);
        Node node6 = new Node();
        node1.setId(6);
        List<Object> node1Neighbors = new LinkedList<>();
        node1Neighbors.add(node2);
        node1Neighbors.add(node3);
        node1.setNeighbors(node1Neighbors);
        List<Object> node2Neighbors = new LinkedList<>();
        node2Neighbors.add(node1);
        node2Neighbors.add(node4);
        node2.setNeighbors(node2Neighbors);
        List<Object> node3Neighbors = new LinkedList<>();
        node3Neighbors.add(node1);
        node3Neighbors.add(node4);
        node3.setNeighbors(node3Neighbors);
        List<Object> node4Neighbors = new LinkedList<>();
        node4Neighbors.add(node2);
        node4Neighbors.add(node6);
        node4.setNeighbors(node4Neighbors);
        List<Object> node5Neighbors = new LinkedList<>();
        node5Neighbors.add(node1);
        node5Neighbors.add(node3);
        node5.setNeighbors(node5Neighbors);
        List<Object> node6Neighbors = new LinkedList<>();
        node6Neighbors.add(node4);
        node6.setNeighbors(node6Neighbors);
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);

        return nodeList;
    }
    private void createGraph()
    {
        Graph graph = new Graph();
        graph.setNodeList(createNodeList());
        List<Node> allNodes = (List<Node>) (Object) createNodeList();
        Node source = allNodes.get(0);
        Bfs bfs = new Bfs(source);
        bfs.run();
        AssertTrue(source.getVisited());

    }
}
