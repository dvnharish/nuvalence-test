package com.nuvalence.rectangle.operations;

import java.util.Objects;


/**
 * The {@code RectangleResponse} class is a response Class of Rectangle Operations
 *
 * @author Harish Duddupudi
 */

public class RectangleResponse {

    /**
     * if there is an intersection between two rectangle
     */
    private String intersection;
    /**
     * if one rectangle is inside other rectangle
     */
    private String containment;
    /**
     * if there is a common border share between two rectangle
     */

    private String adjacency;

    public String getIntersection() {
        return this.intersection;
    }

    public void setIntersection(String intersection) {
        this.intersection = intersection;
    }

    public String getContainment() {
        return this.containment;
    }

    public void setContainment(String containment) {
        this.containment = containment;
    }

    public String getAdjacency() {
        return this.adjacency;
    }

    public void setAdjacency(String adjacency) {
        this.adjacency = adjacency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RectangleResponse)) return false;
        RectangleResponse that = (RectangleResponse) o;
        return getIntersection().equals(that.getIntersection()) &&
                getContainment().equals(that.getContainment()) &&
                getAdjacency().equals(that.getAdjacency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntersection(), getContainment(), getAdjacency());
    }

    @Override
    public String toString() {
        return "RectangleResponse{" +
                "intersection='" + this.intersection + '\'' +
                ", containment='" + this.containment + '\'' +
                ", adjacency='" + this.adjacency + '\'' +
                '}';
    }
}
