
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "xPosition",
    "yPosition",
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
     * x coordinate
     * 
     */
    @JsonProperty("xPosition")
    @JsonPropertyDescription("x coordinate")
    private Integer xPosition;
    /**
     * y coordinate
     * 
     */
    @JsonProperty("yPosition")
    @JsonPropertyDescription("y coordinate")
    private Integer yPosition;
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
     * x coordinate
     * 
     */
    @JsonProperty("xPosition")
    public Integer getXPosition() {
        return xPosition;
    }

    /**
     * x coordinate
     * 
     */
    @JsonProperty("xPosition")
    public void setXPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Node withXPosition(Integer xPosition) {
        this.xPosition = xPosition;
        return this;
    }

    /**
     * y coordinate
     * 
     */
    @JsonProperty("yPosition")
    public Integer getYPosition() {
        return yPosition;
    }

    /**
     * y coordinate
     * 
     */
    @JsonProperty("yPosition")
    public void setYPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public Node withYPosition(Integer yPosition) {
        this.yPosition = yPosition;
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
        return ToStringBuilder.reflectionToString(this);
    }

//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(id).append(xPosition).append(yPosition).append(visited).append(neighbors).append(parent).toHashCode();
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
        return new EqualsBuilder().append(id, rhs.id).append(xPosition, rhs.xPosition).append(yPosition, rhs.yPosition).append(visited, rhs.visited).append(neighbors, rhs.neighbors).append(parent, rhs.parent).isEquals();
    }

}
