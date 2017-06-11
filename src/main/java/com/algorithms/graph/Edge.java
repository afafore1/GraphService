
package com.algorithms.graph;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Edge
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "source",
    "destination",
    "weight",
    "isSettled"
})
public class Edge {

    /**
     * Node Id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Node Id")
    private Integer id;
    /**
     * Source node
     * (Required)
     * 
     */
    @JsonProperty("source")
    @JsonPropertyDescription("Source node")
    private Object source;
    /**
     * Destination node
     * (Required)
     * 
     */
    @JsonProperty("destination")
    @JsonPropertyDescription("Destination node")
    private Object destination;
    /**
     * cost of taking edge between Nodes
     * 
     */
    @JsonProperty("weight")
    @JsonPropertyDescription("cost of taking edge between Nodes")
    private Double weight;
    /**
     * Check if this edge has been settled. Used in Dijkstra's algorithm
     * 
     */
    @JsonProperty("isSettled")
    @JsonPropertyDescription("Check if this edge has been settled. Used in Dijkstra's algorithm")
    private Boolean isSettled;

    /**
     * Node Id
     * 
     */
    @JsonProperty("id")
    protected Integer getId() {
        return id;
    }

    /**
     * Node Id
     * 
     */
    @JsonProperty("id")
    protected void setId(Integer id) {
        this.id = id;
    }

    protected Edge withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Source node
     * (Required)
     * 
     */
    @JsonProperty("source")
    protected Object getSource() {
        return source;
    }

    /**
     * Source node
     * (Required)
     * 
     */
    @JsonProperty("source")
    protected void setSource(Object source) {
        this.source = source;
    }

    protected Edge withSource(Object source) {
        this.source = source;
        return this;
    }

    /**
     * Destination node
     * (Required)
     * 
     */
    @JsonProperty("destination")
    protected Object getDestination() {
        return destination;
    }

    /**
     * Destination node
     * (Required)
     * 
     */
    @JsonProperty("destination")
    protected void setDestination(Object destination) {
        this.destination = destination;
    }

    protected Edge withDestination(Object destination) {
        this.destination = destination;
        return this;
    }

    /**
     * cost of taking edge between Nodes
     * 
     */
    @JsonProperty("weight")
    protected Double getWeight() {
        return weight;
    }

    /**
     * cost of taking edge between Nodes
     * 
     */
    @JsonProperty("weight")
    protected void setWeight(Double weight) {
        this.weight = weight;
    }

    protected Edge withWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    /**
     * Check if this edge has been settled. Used in Dijkstra's algorithm
     * 
     */
    @JsonProperty("isSettled")
    protected Boolean getIsSettled() {
        return isSettled;
    }

    /**
     * Check if this edge has been settled. Used in Dijkstra's algorithm
     * 
     */
    @JsonProperty("isSettled")
    protected void setIsSettled(Boolean isSettled) {
        this.isSettled = isSettled;
    }

    protected Edge withIsSettled(Boolean isSettled) {
        this.isSettled = isSettled;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(source).append(destination).append(weight).append(isSettled).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Edge) == false) {
            return false;
        }
        Edge rhs = ((Edge) other);
        return new EqualsBuilder().append(id, rhs.id).append(source, rhs.source).append(destination, rhs.destination).append(weight, rhs.weight).append(isSettled, rhs.isSettled).isEquals();
    }

}
