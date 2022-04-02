package com.nuvalence.rectangle.operations;

import java.util.Objects;

public class RectangleResponse {
    private String intersection;
    private String containment;
    private String adjacency;

    public String getIntersection() {
        return intersection;
    }

    public void setIntersection(String intersection) {
        this.intersection = intersection;
    }

    public String getContainment() {
        return containment;
    }

    public void setContainment(String containment) {
        this.containment = containment;
    }

    public String getAdjacency() {
        return adjacency;
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
                "intersection='" + intersection + '\'' +
                ", containment='" + containment + '\'' +
                ", adjacency='" + adjacency + '\'' +
                '}';
    }
}
