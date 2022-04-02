package com.nuvalence.rectangle.operations;


import java.util.Objects;
import java.util.logging.Logger;

public class Rectangle {

    private static final Logger logger = Logger.getLogger(Rectangle.class.getName());
    private final Point bottomLeft;
    private final Point topRight;
    private final Point bottomRight;
    private final Point topLeft;
    private final Line topLine;
    private final Line bottomLine;
    private final Line rightLine;
    private final Line leftLine;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.bottomRight = new Point(topRight.x, bottomLeft.y);
        this.topLeft = new Point(bottomLeft.x, topRight.y);
        this.topLine = new Line(this.topLeft, this.topRight);
        this.bottomLine = new Line(this.bottomLeft, this.bottomRight);
        this.rightLine = new Line(this.bottomRight, this.topRight);
        this.leftLine = new Line(this.bottomLeft, this.topLeft);
        logger.info(this.toString());
    }

    public String contains(Rectangle other) {
        return (other.bottomLeft.getX() >= this.bottomLeft.getX()) && (other.topRight.getX() <= this.topRight.getX())
                && (other.bottomLeft.getY() >= this.bottomLeft.getY()) && (other.topRight.getY() <= this.topRight.getY()) ? Constants.CONTAINMENT : Constants.NO_CONTAINMENT;
    }

    public boolean isIntersecting(Rectangle other) {
        if (!this.contains(other).equals(Constants.CONTAINMENT)) {
            return this.topRight.getX() > other.bottomLeft.getX() && this.topRight.getY() > other.bottomLeft.getY()
                    && other.topRight.getX() > this.bottomLeft.getX()
                    && other.topRight.getY() > this.bottomLeft.getY();
        }
        return false;
    }

    public String adjacentSharing(Rectangle other) {
        //use hashmap
        // remove multiple returns and use return string

        String adjacentStatus=Constants.NOT_ADJACENT;


        String externalBottom = isLinesOverlapping(this.bottomLine, other.topLine);
        String externalTop = isLinesOverlapping(this.topLine, other.bottomLine);
        String externalRight = isLinesOverlapping(this.rightLine, other.leftLine);
        String externalLeft = isLinesOverlapping(this.leftLine, other.rightLine);
        String innerBottom = isLinesOverlapping(this.bottomLine, other.bottomLine);
        String innerTop = isLinesOverlapping(this.topLine, other.topLine);
        String innerRight = isLinesOverlapping(this.rightLine, other.rightLine);
        String innerLeft = isLinesOverlapping(this.leftLine, other.leftLine);

        if (this.bottomLine.equals(other.topLine) || this.topLine.equals(other.bottomLine)
                || this.rightLine.equals(other.leftLine) || this.leftLine.equals(other.rightLine)) {
            adjacentStatus= Constants.ADJACENT_PROPER;

        }
        else if (this.topLine.equals(other.topLine) || this.bottomLine.equals(other.bottomLine)
                || this.rightLine.equals(other.rightLine) || this.leftLine.equals(other.leftLine)) {
            adjacentStatus= Constants.INTERNAL + Constants.ADJACENT_PROPER;
        }


        else if (this.topRight.equals(other.bottomLeft) || this.topLeft.equals(other.bottomRight)
                || this.bottomRight.equals(other.topLeft) || this.bottomLeft.equals(other.topRight)) {
            adjacentStatus= Constants.VERTEX_SHARE;
        }



        if (!externalBottom.equals(Constants.NOT_ADJACENT)) {
            adjacentStatus= externalBottom;
        }
        if (!externalTop.equals(Constants.NOT_ADJACENT)) {
            adjacentStatus= externalTop;
        }
        if (!externalRight.equals(Constants.NOT_ADJACENT)) {
            adjacentStatus= externalRight;
        }
        if (!externalLeft.equals(Constants.NOT_ADJACENT)) {
            adjacentStatus= externalLeft;
        }


        if (
                this.topRight.getY().equals(other.topRight.getY()) && this.topRight.getX() >= other.topRight.getX() ||
                        this.topLeft.getY().equals(other.topLeft.getY()) && this.topLeft.getX() <= other.topLeft.getX() ||
                        this.topRight.getX().equals(other.topRight.getX()) && this.topRight.getY() >= other.topRight.getY() ||
                        this.topLeft.getX().equals(other.topLeft.getX()) && this.topLeft.getY() <= other.topLeft.getY() ||
                        this.bottomLeft.getY().equals(other.bottomLeft.getY()) && this.bottomLeft.getX() <= other.bottomLeft.getX() ||
                        this.bottomRight.getY().equals(other.bottomRight.getY()) && this.bottomRight.getX() >= other.bottomRight.getX() ||
                        this.bottomLeft.getX().equals(other.bottomLeft.getX()) && this.bottomLeft.getY() <= other.bottomLeft.getY() ||
                        this.bottomRight.getX().equals(other.bottomRight.getX()) && this.bottomRight.getY() >= other.bottomRight.getY()

        ) {

            if (!innerBottom.equals(Constants.NOT_ADJACENT)) {
                adjacentStatus= Constants.INTERNAL + "" + innerBottom;
            }
            else if (!innerTop.equals(Constants.NOT_ADJACENT)) {
                adjacentStatus= Constants.INTERNAL + "" + innerTop;
            }
            else if (!innerRight.equals(Constants.NOT_ADJACENT)) {
                adjacentStatus= Constants.INTERNAL + "" + innerRight;
            }
            else if (!innerLeft.equals(Constants.NOT_ADJACENT)) {
                adjacentStatus= Constants.INTERNAL + "" + innerLeft;
            }
        }
        return adjacentStatus;

    }

    private String isLinesOverlapping(Line thisLine, Line otherLine) {
        if (thisLine.getA().getY().equals(otherLine.getA().getY()) && thisLine.getB().getY().equals(otherLine.getB().getY())) {
            if ((thisLine.getA().getX() < otherLine.getA().getX() && otherLine.getB().getX() < thisLine.getB().getX())) {
                return Constants.ADJACENT_SUB_LINE;
            }
           else if (thisLine.getA().getX() >= otherLine.getA().getX() && otherLine.getB().getX() >= thisLine.getB().getX()) {
                return Constants.ADJACENT_OVERFLOW;
            }
            else if ((thisLine.getA().getX() < otherLine.getA().getX()) && (thisLine.getB().getX() < otherLine.getB().getX())
                    || ((otherLine.getA().getX() < thisLine.getA().getX()) && (otherLine.getB().getX() < thisLine.getB().getX()))) {
                return Constants.PARTIAL_ADJACENT;
            }

        } else if (thisLine.getA().getX().equals(otherLine.getA().getX()) && thisLine.getB().getX().equals(otherLine.getB().getX())) {
            if (thisLine.getA().getY() <= otherLine.getA().getY() && otherLine.getB().getY() <= thisLine.getB().getY()) {
                return Constants.ADJACENT_SUB_LINE;
            }
            else if (thisLine.getA().getY() >= otherLine.getA().getY() && otherLine.getB().getY() >= thisLine.getB().getY()) {
                return Constants.ADJACENT_OVERFLOW;
            }
            else if ((thisLine.getA().getY() < otherLine.getA().getY()) && (thisLine.getB().getY() < otherLine.getB().getY())
                    || ((otherLine.getA().getY() < thisLine.getA().getY()) && (otherLine.getB().getY() < thisLine.getB().getY()))) {
                return Constants.PARTIAL_ADJACENT;
            }
        }

        return Constants.NOT_ADJACENT;
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
        return "Rectangle{" +
                "bottomLeft=" + bottomLeft +
                ", topRight=" + topRight +
                ", bottomRight=" + bottomRight +
                ", topLeft=" + topLeft +
                ", topLine=" + topLine +
                ", bottomLine=" + bottomLine +
                ", rightLine=" + rightLine +
                ", leftLine=" + leftLine +
                '}';
    }
}