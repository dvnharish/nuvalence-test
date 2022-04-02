package com.nuvalence.rectangle.operations;

public class Point {

    Double x, y;

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.x == null) ? 0 : this.x.hashCode());
        result = prime * result + ((this.y == null) ? 0 : this.y.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (this.x == null) {
            if (other.x != null)
                return false;
        } else if (!this.x.equals(other.x))
            return false;
        if (this.y == null) {
            return other.y == null;
        } else
            return this.y.equals(other.y);
    }

    @Override
    public String toString() {
        return "Point [x=" + this.x + ", y=" + this.y + "]";
    }

}
