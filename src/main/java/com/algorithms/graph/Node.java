
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
 * Node
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "xPosition",
    "yPosition",
    "neighbors"
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
     * Neighbors to this node
     * 
     */
    @JsonProperty("neighbors")
    @JsonPropertyDescription("Neighbors to this node")
    private List<Object> neighbors = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Node withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(xPosition).append(yPosition).append(neighbors).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Node) == false) {
            return false;
        }
        Node rhs = ((Node) other);
        return new EqualsBuilder().append(id, rhs.id).append(xPosition, rhs.xPosition).append(yPosition, rhs.yPosition).append(neighbors, rhs.neighbors).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
