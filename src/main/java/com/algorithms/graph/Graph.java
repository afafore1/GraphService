
package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Graph
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Node",
    "Edge",
    "NodeList",
    "EdgeList"
})
public class Graph {

    @JsonProperty("Node")
    private Node node;
    @JsonProperty("Edge")
    private Edge edge;
    /**
     * List containing all Nodes in Graph
     * 
     */
    @JsonProperty("NodeList")
    @JsonPropertyDescription("List containing all Nodes in Graph")
    private List<Object> nodeList = new ArrayList<Object>();
    /**
     * List containing all Edges in Graph
     * 
     */
    @JsonProperty("EdgeList")
    @JsonPropertyDescription("List containing all Edges in Graph")
    private List<Object> edgeList = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Node")
    public Node getNode() {
        return node;
    }

    @JsonProperty("Node")
    public void setNode(Node node) {
        this.node = node;
    }

    public Graph withNode(Node node) {
        this.node = node;
        return this;
    }

    @JsonProperty("Edge")
    public Edge getEdge() {
        return edge;
    }

    @JsonProperty("Edge")
    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Graph withEdge(Edge edge) {
        this.edge = edge;
        return this;
    }

    /**
     * List containing all Nodes in Graph
     * 
     */
    @JsonProperty("NodeList")
    public List<Object> getNodeList() {
        return nodeList;
    }

    /**
     * List containing all Nodes in Graph
     * 
     */
    @JsonProperty("NodeList")
    public void setNodeList(List<Object> nodeList) {
        this.nodeList = nodeList;
    }

    public Graph withNodeList(List<Object> nodeList) {
        this.nodeList = nodeList;
        return this;
    }

    /**
     * List containing all Edges in Graph
     * 
     */
    @JsonProperty("EdgeList")
    public List<Object> getEdgeList() {
        return edgeList;
    }

    /**
     * List containing all Edges in Graph
     * 
     */
    @JsonProperty("EdgeList")
    public void setEdgeList(List<Object> edgeList) {
        this.edgeList = edgeList;
    }

    public Graph withEdgeList(List<Object> edgeList) {
        this.edgeList = edgeList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Graph withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(node).append(edge).append(nodeList).append(edgeList).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Graph) == false) {
            return false;
        }
        Graph rhs = ((Graph) other);
        return new EqualsBuilder().append(node, rhs.node).append(edge, rhs.edge).append(nodeList, rhs.nodeList).append(edgeList, rhs.edgeList).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
