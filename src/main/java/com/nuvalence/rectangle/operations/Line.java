package com.nuvalence.rectangle.operations;

/**
 * This {@code Line} represents a line segment in {@code Point (x,y) a,@code Point (x,y) b} a 2D coordinate space.
 * <p>
 */

public class Line {
    Point a;
    Point b;

    /**
     * The  {@code Point (x,y) a,@code Point (x,y) b} are two points in a 2D coordinate where {@Code Point a} represent starting point and {@Code Point b} represent ending point .
     */

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    private Line() {

    }

    public Point getA() {
        return this.a;
    }

    public Point getB() {
        return this.b;
    }

    @Override
    public String toString() {
        return "Line [a=" + this.a + ", b=" + this.b + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.a == null) ? 0 : this.a.hashCode());
        result = prime * result + ((this.b == null) ? 0 : this.b.hashCode());
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
        Line other = (Line) obj;
        if (this.a == null) {
            if (other.a != null)
                return false;
        } else if (!this.a.equals(other.a))
            return false;
        if (this.b == null) {
            return other.b == null;
        } else return this.b.equals(other.b);
    }

}