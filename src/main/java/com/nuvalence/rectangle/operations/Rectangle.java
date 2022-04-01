package com.nuvalence.rectangle.operations;


import java.util.Objects;

public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;
    private final Point bottomRight;
    private final Point topLeft;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        if (Double.isNaN(this.bottomLeft.getX()) || Double.isNaN(this.topRight.getX()))
            throw new IllegalArgumentException("x-coordinate cannot be z");
        if (Double.isNaN(this.bottomLeft.getY()) || Double.isNaN(this.topRight.getY()))
            throw new IllegalArgumentException("y-coordinates cannot be NaN");
        if (this.topRight.getX() < this.bottomLeft.getX() || this.topRight.getY() < this.bottomLeft.getY()) {
            throw new IllegalArgumentException("Invalid rectangle");
        }
        this.bottomRight = new Point(topRight.x, bottomLeft.y);
        this.topLeft = new Point(bottomLeft.x, topRight.y);
    }

    public boolean isIntersecting(Rectangle other) {
        return this.topRight.getX() >= other.bottomLeft.getX() && this.topRight.getY() >= other.bottomLeft.getY()
                && other.topRight.getX() >= this.bottomLeft.getX()
                && other.topRight.getY() >= this.bottomLeft.getY();
    }

    public String sharing(Rectangle other) {

        Line rect1TopLine = new Line(this.topLeft, this.topRight);
        Line rect1BottomLine = new Line(this.bottomLeft, this.bottomRight);
        Line rect1RightLine = new Line(this.bottomRight, this.topRight);
        Line rect1LeftLine = new Line(this.bottomLeft, this.topLeft);

        Line rect2TopLine = new Line(other.topLeft, other.topRight);
        Line rect2BottomLine = new Line(other.bottomLeft, other.bottomRight);
        Line rect2RightLine = new Line(other.bottomRight, other.topRight);
        Line rect2LeftLine = new Line(other.bottomLeft, other.topLeft);

        if (rect1BottomLine.equals(rect2TopLine) || rect1TopLine.equals(rect2BottomLine)
                || rect1RightLine.equals(rect2LeftLine) || rect1LeftLine.equals(rect2RightLine)) {
            return "Adjacent Proper";

        }

        if (rect1TopLine.equals(rect2TopLine) || rect1BottomLine.equals(rect2BottomLine)
                || rect1RightLine.equals(rect2RightLine) || rect1LeftLine.equals(rect2LeftLine)) {
            return "Internal Adjacent Proper";

        }

        if (this.topRight.equals(other.bottomLeft) || this.topLeft.equals(other.bottomRight)
                || this.bottomRight.equals(other.topLeft) || this.bottomLeft.equals(other.topRight)) {
            return "Vertex Share";
        }

        String bottom = isLinesOverlapping(rect1BottomLine, rect2TopLine);
        String top = isLinesOverlapping(rect1TopLine, rect2BottomLine);
        String right = isLinesOverlapping(rect1RightLine, rect2LeftLine);
        String left = isLinesOverlapping(rect1LeftLine, rect2RightLine);
        if (!bottom.equals(Constants.NOT_OVERRIDING)) {
            return bottom;
        }
        if (!top.equals(Constants.NOT_OVERRIDING)) {
            return top;
        }
        if (!right.equals(Constants.NOT_OVERRIDING)) {
            return right;
        }
        if (!left.equals(Constants.NOT_OVERRIDING)) {
            return left;
        }
        return Constants.NOT_OVERRIDING;
    }

    private String isLinesOverlapping(Line l1, Line l2) {
        if (l1.getA().getY().equals(l2.getA().getY()) && l1.getB().getY().equals(l2.getB().getY())) {
            if ((l1.getA().getX() <= l2.getA().getX() && l2.getB().getX() <= l1.getB().getX())) {
                return Constants.ADJACENT_SUB_LINE;
            }

            if (l1.getA().getX() >= l2.getA().getX() && l2.getB().getX() >= l1.getB().getX()) {
                return Constants.ADJACENT_OVERFLOW;
            }
            if ((l1.getA().getX() < l2.getA().getX()) && (l1.getB().getX() < l2.getB().getX())
                    || ((l2.getA().getX() < l1.getA().getX()) && (l2.getB().getX() < l1.getB().getX()))) {
                return Constants.PARTIAL_ADJACENT;

            }

        } else if (l1.getA().getX().equals(l2.getA().getX()) && l1.getB().getX().equals(l2.getB().getX())) {
            if (l1.getA().getY() <= l2.getA().getY() && l2.getB().getY() <= l1.getB().getY()) {
                return Constants.ADJACENT_SUB_LINE;
            }
            if (l1.getA().getY() >= l2.getA().getY() && l2.getB().getY() >= l1.getB().getY()) {
                return Constants.ADJACENT_OVERFLOW;
            }
            if ((l1.getA().getY() < l2.getA().getY()) && (l1.getB().getY() < l2.getB().getY())
                    || ((l2.getA().getY() < l1.getA().getY()) && (l2.getB().getY() < l1.getB().getY()))) {
                return Constants.PARTIAL_ADJACENT;
            }

        }

        return Constants.NOT_OVERRIDING;
    }


    public boolean contains(Rectangle other) {
        return (other.bottomLeft.getX() >= this.bottomLeft.getX()) && (other.topRight.getX() <= this.topRight.getX())
                && (other.bottomLeft.getY() >= this.bottomLeft.getY()) && (other.topRight.getY() <= this.topRight.getY());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bottomLeft == null) ? 0 : bottomLeft.hashCode());
        result = prime * result + ((bottomRight == null) ? 0 : bottomRight.hashCode());
        result = prime * result + ((topLeft == null) ? 0 : topLeft.hashCode());
        result = prime * result + ((topRight == null) ? 0 : topRight.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(bottomLeft, rectangle.bottomLeft) &&
                Objects.equals(topRight, rectangle.topRight) &&
                Objects.equals(bottomRight, rectangle.bottomRight) &&
                Objects.equals(topLeft, rectangle.topLeft);
    }

    @Override
    public String toString() {
        return "Rectangle [bottomLeft=" + bottomLeft + ", topRight=" + topRight + ", bottomRight=" + bottomRight
                + ", topLeft=" + topLeft + "]";
    }

}