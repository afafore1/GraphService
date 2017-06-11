
package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Node
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "value",
    "visited",
    "neighbors",
    "parent"
})
public class Node {

    /**
     * Node Id
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Node Id")
    private Integer id;
    /**
     * The value gives a description of what this node is
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("The value gives a description of what this node is")
    private String value;
    /**
     * x coordinate
     * 
     */
    /**
     * Verify if this node has been visited
     * 
     */
    @JsonProperty("visited")
    @JsonPropertyDescription("Verify if this node has been visited")
    private Boolean visited;
    /**
     * Neighbors to this node
     * 
     */
    @JsonProperty("neighbors")
    @JsonPropertyDescription("Neighbors to this node")
    private List<Object> neighbors = new ArrayList<Object>();
    /**
     * Parent Node
     * 
     */
    @JsonProperty("parent")
    @JsonPropertyDescription("Parent Node")
    private Object parent;

    /**
     * Node Id
     * (Required)
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Node Id
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Node withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * The value gives a description of what this node is
     * 
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * The value gives a description of what this node is
     * 
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Node withValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Verify if this node has been visited
     * 
     */
    @JsonProperty("visited")
    public Boolean getVisited() {
        return visited;
    }

    /**
     * Verify if this node has been visited
     * 
     */
    @JsonProperty("visited")
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Node withVisited(Boolean visited) {
        this.visited = visited;
        return this;
    }

    /**
     * Neighbors to this node
     * 
     */
    @JsonProperty("neighbors")
    public List<Object> getNeighbors() {
        return neighbors;
    }

    /**
     * Neighbors to this node
     * 
     */
    @JsonProperty("neighbors")
    public void setNeighbors(List<Object> neighbors) {
        this.neighbors = neighbors;
    }

    public Node withNeighbors(List<Object> neighbors) {
        this.neighbors = neighbors;
        return this;
    }

    /**
     * Parent Node
     * 
     */
    @JsonProperty("parent")
    public Object getParent() {
        return parent;
    }

    /**
     * Parent Node
     * 
     */
    @JsonProperty("parent")
    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Node withParent(Object parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        return this.getId()+""+this.getValue()+""+this.getVisited();
    }

//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(id).append(value).append(xPosition).append(yPosition).append(visited).append(neighbors).append(parent).toHashCode();
//    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Node) == false) {
            return false;
        }
        Node rhs = ((Node) other);
        return new EqualsBuilder().append(id, rhs.id).append(value, rhs.value).append(visited, rhs.visited).append(neighbors, rhs.neighbors).append(parent, rhs.parent).isEquals();
    }

}
