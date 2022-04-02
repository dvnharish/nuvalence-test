package com.nuvalence.rectangle.operations;


import java.util.Objects;

/**
 * The {@code Rectangle} class is an immutable data type to show a
 * two-dimensional axis-aligned Rectangle with real-value coordinates.
 * The rectangle is <em>closed</em>—it includes the points on the boundary.
 *
 * @author Harish Duddupudi
 */


public class Rectangle {
    private Point bottomLeft;
    private Point topRight;
    private Point bottomRight;
    private Point topLeft;
    private Line topLine;
    private Line bottomLine;
    private Line rightLine;
    private Line leftLine;


    /**
     * Initializes a new rectangle [ <em>bottomLeft</em>, <em>topRight</em>]
     *
     * @param bottomLeft the <em>x</em>-coordinates of the bottom-left of the Rectangle
     * @param topRight   the <em>x</em>-coordinates of the top-right of the Rectangle
     * @throws IllegalArgumentException if any of {@code bottomLeft}, {@code bottomLeft} is {@code Double.NaN}.
     * @throws IllegalArgumentException if {@code topRight.getX() < bottomLeft.getX() } or {@code topRight.getY() < bottomLeft.getY()}.
     */
    public Rectangle(Point bottomLeft, Point topRight) {

        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.bottomRight = new Point(topRight.x, bottomLeft.y);
        this.topLeft = new Point(bottomLeft.x, topRight.y);
        this.topLine = new Line(this.topLeft, this.topRight);
        this.bottomLine = new Line(this.bottomLeft, this.bottomRight);
        this.rightLine = new Line(this.bottomRight, this.topRight);
        this.leftLine = new Line(this.bottomLeft, this.topLeft);
        edgeCaseCheckForNaN();

    }

    /**
     * Private Constructor will not allow to create a customized Rectangle.
     */
    private Rectangle() {
    }

    /**
     * Edge Cases checking for NaN and Invalid Rectangles
     */
    private void edgeCaseCheckForNaN() {
        if (Double.isNaN(this.bottomLeft.getX()) || Double.isNaN(this.topRight.getX()))
            throw new IllegalArgumentException(Constants.X_CANNOT_BE_NULL);
        if (Double.isNaN(this.bottomLeft.getY()) || Double.isNaN(this.topRight.getY()))
            throw new IllegalArgumentException(Constants.Y_CANNOT_BE_NULL);
        if (this.topRight.getX() < this.bottomLeft.getX() || this.topRight.getY() < this.bottomLeft.getY()) {
            throw new IllegalArgumentException(Constants.INVALID_RECTANGLE);
        }
    }

    /**
     * Returns true if this rectangle contain the rectangle.
     * @param  other the rectangle
     * @return {@code Containment} if this rectangle contain the rectangle {@code other},
     * @return {@code No-Containment} if this rectangle does not contain the rectangle {@code other}
     */
    public String contains(Rectangle other) {
        return (other.bottomLeft.getX() >= this.bottomLeft.getX()) && (other.topRight.getX() <= this.topRight.getX())
                && (other.bottomLeft.getY() >= this.bottomLeft.getY()) && (other.topRight.getY() <= this.topRight.getY()) ? Constants.CONTAINMENT : Constants.NO_CONTAINMENT;
    }

    /**
     * Returns true if the two rectangles are Intersecting.
     *
     * @param  other the other rectangle
     * @return {@code true} if this rectangle intersect the other rectangle at one or more points
     */
    public boolean isIntersecting(Rectangle other) {
        if (!this.contains(other).equals(Constants.CONTAINMENT)) {
            return this.topRight.getX() > other.bottomLeft.getX() && this.topRight.getY() > other.bottomLeft.getY()
                    && other.topRight.getX() > this.bottomLeft.getX()
                    && other.topRight.getY() > this.bottomLeft.getY();
        }
        return false;
    }

    /**
     * Returns the sharing status if the two rectangles are sharing a border.
     *
     * @param  other the other rectangle
     * @return {@code Partial Adjacent } if this rectangle is sharing border the other rectangle partially
     * @return {@code Adjacent (Overflow)} if this rectangle is sharing border the other rectangle and overflowing the length or width of this rectangle
     * @return {@code Adjacent (Sub-line)} if this rectangle is sharing border the other rectangle sub line
     * @return {@code Not Adjacent} if this rectangle is not sharing border the other rectangle completely
     * @return {@code Vertex Share} if this rectangle is sharing Vertex the other rectangle
     */
    public String adjacentSharing(Rectangle other) {
        String adjacentShareStatus = Constants.NOT_ADJACENT;




        if (this.bottomLine.equals(other.topLine) || this.topLine.equals(other.bottomLine)
                || this.rightLine.equals(other.leftLine) || this.leftLine.equals(other.rightLine)) {
            return Constants.ADJACENT_PROPER;

        } else if (this.topLine.equals(other.topLine) || this.bottomLine.equals(other.bottomLine)
                || this.rightLine.equals(other.rightLine) || this.leftLine.equals(other.leftLine)) {
            return Constants.INTERNAL + Constants.ADJACENT_PROPER;
        } else if (this.topRight.equals(other.bottomLeft) || this.topLeft.equals(other.bottomRight)
                || this.bottomRight.equals(other.topLeft) || this.bottomLeft.equals(other.topRight)) {
            return Constants.VERTEX_SHARE;
        }

        String externalBottom = isLinesOverlapping(this.bottomLine, other.topLine);
        String externalTop = isLinesOverlapping(this.topLine, other.bottomLine);
        String externalRight = isLinesOverlapping(this.rightLine, other.leftLine);
        String externalLeft = isLinesOverlapping(this.leftLine, other.rightLine);


        adjacentShareStatus = getExternalShareStatusIfAdjacent(adjacentShareStatus, externalBottom, externalTop, externalRight, externalLeft);
        if (isTopRightSharingBorder(other) || isTopLeftSharingBorder(other) || isBottomLeftSharingBorder(other) || isBottomRightSharingBorder(other)) {
            String innerBottom = isLinesOverlapping(this.bottomLine, other.bottomLine);
            String innerTop = isLinesOverlapping(this.topLine, other.topLine);
            String innerRight = isLinesOverlapping(this.rightLine, other.rightLine);
            String innerLeft = isLinesOverlapping(this.leftLine, other.leftLine);
            if(externalBottom.equals(Constants.NOT_ADJACENT)
                    && externalTop.equals(Constants.NOT_ADJACENT)&&
                    externalRight.equals(Constants.NOT_ADJACENT)&
                    externalLeft.equals(Constants.NOT_ADJACENT)){
                adjacentShareStatus = getInternalShareStatusIfAdjacent(innerBottom, innerTop, innerRight, innerLeft);

            }
        }
        return adjacentShareStatus;

    }

    /**
     * @param other checking if this rectangle bottom right point is sharing
     * @return true if sharing
     * @return false if not sharing
     */
    private boolean isBottomRightSharingBorder(Rectangle other) {
        return this.bottomRight.getY().equals(other.bottomRight.getY()) && this.bottomRight.getX() >= other.bottomRight.getX() ||
                this.bottomRight.getX().equals(other.bottomRight.getX()) && this.bottomRight.getY() >= other.bottomRight.getY();
    }

    /**
     * @param other checking if this rectangle bottom left point  is sharing
     * @return true if sharing
     * @return false if not sharing
     */
    private boolean isBottomLeftSharingBorder(Rectangle other) {
        return this.bottomLeft.getY().equals(other.bottomLeft.getY()) && this.bottomLeft.getX() <= other.bottomLeft.getX() ||
                this.bottomLeft.getX().equals(other.bottomLeft.getX()) && this.bottomLeft.getY() <= other.bottomLeft.getY();
    }

    /**
     * @param other checking if this rectangle top left point  is sharing
     * @return true if sharing
     * @return false if not sharing
     */
    private boolean isTopLeftSharingBorder(Rectangle other) {
        return this.topLeft.getY().equals(other.topLeft.getY()) && this.topLeft.getX() <= other.topLeft.getX() ||
                this.topLeft.getX().equals(other.topLeft.getX()) && this.topLeft.getY() <= other.topLeft.getY();
    }

    /**
     * @param other checking if this rectangle top right point  is sharing
     * @return true if sharing
     * @return false if not sharing
     */

    private boolean isTopRightSharingBorder(Rectangle other) {
        return this.topRight.getY().equals(other.topRight.getY()) && this.topRight.getX() >= other.topRight.getX() ||
                this.topRight.getX().equals(other.topRight.getX()) && this.topRight.getY() >= other.topRight.getY();
    }

    /**
     * @param innerBottom checking if other rectangle is inner bottom of this rectangle
     * @param innerTop checking if other rectangle is inner top of this rectangle
     * @param innerRight checking if other rectangle is inner right of this rectangle
     * @param innerLeft checking if other rectangle is inner left of this rectangle
     * @return adjacentShareStatus the status if they share borders internally
     */
    private String getInternalShareStatusIfAdjacent(String innerBottom, String innerTop, String innerRight, String innerLeft) {
        String adjacentShareStatus;
        if (!innerBottom.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = Constants.INTERNAL + "" + innerBottom;
        } else if (!innerTop.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = Constants.INTERNAL + "" + innerTop;
        } else if (!innerRight.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = Constants.INTERNAL + "" + innerRight;
        } else if (!innerLeft.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = Constants.INTERNAL + "" + innerLeft;
        } else {
            adjacentShareStatus = Constants.INTERNAL;
        }
        return adjacentShareStatus;
    }

    /**
     * Returns the sharing status if the two rectangles are sharing a border externally.
     *
     * @param  externalBottom status of the external bottom line of this rectangle share a border with external top of the other rectangle
     * @param  externalTop status of the external top line of this rectangle share a border with external bottom of the other rectangle
     * @param  externalRight status of the external right line of this rectangle share a border with external left of the other rectangle
     * @param  externalLeft status of the external left line of this rectangle share a border with external right of the other rectangle
     * @return {@code adjacentShareStatus } the status of the rectangle if they share borders
     */
    private String getExternalShareStatusIfAdjacent(String adjacentShareStatus, String externalBottom, String externalTop, String externalRight, String externalLeft) {
        if (!externalBottom.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = externalBottom;
        } else if (!externalTop.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = externalTop;
        } else if (!externalRight.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = externalRight;
        } else if (!externalLeft.equals(Constants.NOT_ADJACENT)) {
            adjacentShareStatus = externalLeft;
        }
        return adjacentShareStatus;
    }


    /**
     * @param thisLine borderline of this rectangle
     * @param otherLine borderline of other rectangle
     * @return linesOverlappingStatus status of the lines if they are overlapping with eac hother
     */
    private String isLinesOverlapping(Line thisLine, Line otherLine) {
        String linesOverlappingStatus = Constants.NOT_ADJACENT;
        if (thisLine.getA().getY().equals(otherLine.getA().getY()) && thisLine.getB().getY().equals(otherLine.getB().getY())) {
            linesOverlappingStatus = getAdjacencyOnXAxis(thisLine, otherLine, linesOverlappingStatus);
        } else if (thisLine.getA().getX().equals(otherLine.getA().getX()) && thisLine.getB().getX().equals(otherLine.getB().getX())) {
            linesOverlappingStatus = getAdjacencyOnYAxis(thisLine, otherLine, linesOverlappingStatus);
        }

        return linesOverlappingStatus;
    }

    /**
     * @param thisLine borderline of this rectangle
     * @param otherLine borderline of other rectangle
     * @return linesOverlappingStatus status of the lines if they are overlapping with each other on X axis
     * @return linesOverlappingStatus updating the overlapping status
     */
    private String getAdjacencyOnXAxis(Line thisLine, Line otherLine, String linesOverlappingStatus) {
        if ((thisLine.getA().getX() <= otherLine.getA().getX() && otherLine.getB().getX() <= thisLine.getB().getX())) {
            linesOverlappingStatus = Constants.ADJACENT_SUB_LINE;
        } else if (thisLine.getA().getX() >= otherLine.getA().getX() && otherLine.getB().getX() >= thisLine.getB().getX()) {
            linesOverlappingStatus = Constants.ADJACENT_OVERFLOW;
        } else if ((thisLine.getA().getX() < otherLine.getA().getX()) && (thisLine.getB().getX() < otherLine.getB().getX())
                || ((otherLine.getA().getX() < thisLine.getA().getX()) && (otherLine.getB().getX() < thisLine.getB().getX()))) {
            linesOverlappingStatus = Constants.PARTIAL_ADJACENT;
        }
        return linesOverlappingStatus;
    }
    /**
     * @param thisLine borderline of this rectangle
     * @param otherLine borderline of other rectangle
     * @return linesOverlappingStatus status of the lines if they are overlapping with each other on Y axis
     * @return linesOverlappingStatus updating the overlapping status
     */
    private String getAdjacencyOnYAxis(Line thisLine, Line otherLine, String linesOverlappingStatus) {
        if (thisLine.getA().getY() <= otherLine.getA().getY() && otherLine.getB().getY() <= thisLine.getB().getY()) {
            linesOverlappingStatus = Constants.ADJACENT_SUB_LINE;
        } else if (thisLine.getA().getY() >= otherLine.getA().getY() && otherLine.getB().getY() >= thisLine.getB().getY()) {
            linesOverlappingStatus = Constants.ADJACENT_OVERFLOW;
        } else if ((thisLine.getA().getY() < otherLine.getA().getY()) && (thisLine.getB().getY() < otherLine.getB().getY())
                || ((otherLine.getA().getY() < thisLine.getA().getY()) && (otherLine.getB().getY() < thisLine.getB().getY()))) {
            linesOverlappingStatus = Constants.PARTIAL_ADJACENT;
        }
        return linesOverlappingStatus;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.bottomLeft == null) ? 0 : this.bottomLeft.hashCode());
        result = prime * result + ((this.bottomRight == null) ? 0 : this.bottomRight.hashCode());
        result = prime * result + ((this.topLeft == null) ? 0 : this.topLeft.hashCode());
        result = prime * result + ((this.topRight == null) ? 0 : this.topRight.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(this.bottomLeft, rectangle.bottomLeft) &&
                Objects.equals(this.topRight, rectangle.topRight) &&
                Objects.equals(this.bottomRight, rectangle.bottomRight) &&
                Objects.equals(this.topLeft, rectangle.topLeft);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "bottomLeft=" + this.bottomLeft +
                ", topRight=" + this.topRight +
                ", bottomRight=" + this.bottomRight +
                ", topLeft=" + this.topLeft +
                ", topLine=" + this.topLine +
                ", bottomLine=" + this.bottomLine +
                ", rightLine=" + this.rightLine +
                ", leftLine=" + this.leftLine +
                '}';
    }
}