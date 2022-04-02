package com.nuvalence.rectangle.operations;

public class BasicRectangle {
    private final Point bottomLeft;
    private final Point topRight;

    public BasicRectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        if (Double.isNaN(this.bottomLeft.getX()) || Double.isNaN(this.topRight.getX()))
            throw new IllegalArgumentException(Constants.X_CANNOT_BE_NULL);
        if (Double.isNaN(this.bottomLeft.getY()) || Double.isNaN(this.topRight.getY()))
            throw new IllegalArgumentException(Constants.Y_CANNOT_BE_NULL);
        if (this.topRight.getX() < this.bottomLeft.getX() || this.topRight.getY() < this.bottomLeft.getY()) {
            throw new IllegalArgumentException(Constants.INVALID_RECTANGLE);
        }

    }

}
