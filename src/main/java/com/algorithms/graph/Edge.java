
package com.algorithms.graph;

import java.util.HashMap;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "source",
    "destination",
    "weight",
    "isSettled"
})
public class Edge {

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
     * Weight of edge between Nodes
     * 
     */
    @JsonProperty("weight")
    @JsonPropertyDescription("Weight of edge between Nodes")
    private Double weight;
    /**
     * Check if this edge has been settled. Used in Dijkstra's algorithm
     * 
     */
    @JsonProperty("isSettled")
    @JsonPropertyDescription("Check if this edge has been settled. Used in Dijkstra's algorithm")
    private Boolean isSettled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Source node
     * (Required)
     * 
     */
    @JsonProperty("source")
    public Object getSource() {
        return source;
    }

    /**
     * Source node
     * (Required)
     * 
     */
    @JsonProperty("source")
    public void setSource(Object source) {
        this.source = source;
    }

    public Edge withSource(Object source) {
        this.source = source;
        return this;
    }

    /**
     * Destination node
     * (Required)
     * 
     */
    @JsonProperty("destination")
    public Object getDestination() {
        return destination;
    }

    /**
     * Destination node
     * (Required)
     * 
     */
    @JsonProperty("destination")
    public void setDestination(Object destination) {
        this.destination = destination;
    }

    public Edge withDestination(Object destination) {
        this.destination = destination;
        return this;
    }

    /**
     * Weight of edge between Nodes
     * 
     */
    @JsonProperty("weight")
    public Double getWeight() {
        return weight;
    }

    /**
     * Weight of edge between Nodes
     * 
     */
    @JsonProperty("weight")
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Edge withWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    /**
     * Check if this edge has been settled. Used in Dijkstra's algorithm
     * 
     */
    @JsonProperty("isSettled")
    public Boolean getIsSettled() {
        return isSettled;
    }

    /**
     * Check if this edge has been settled. Used in Dijkstra's algorithm
     * 
     */
    @JsonProperty("isSettled")
    public void setIsSettled(Boolean isSettled) {
        this.isSettled = isSettled;
    }

    public Edge withIsSettled(Boolean isSettled) {
        this.isSettled = isSettled;
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

    public Edge withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(source).append(destination).append(weight).append(isSettled).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(source, rhs.source).append(destination, rhs.destination).append(weight, rhs.weight).append(isSettled, rhs.isSettled).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
