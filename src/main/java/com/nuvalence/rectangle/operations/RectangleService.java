package com.nuvalence.rectangle.operations;

public class RectangleService {
    public RectangleResponse operations(Rectangle rectangle1, Rectangle rectangle2) {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setContainment(rectangle1.contains(rectangle2));
        if (!rectangle1.contains(rectangle2).equals(Constants.CONTAINMENT)) {
            if (rectangle1.isIntersecting(rectangle2)) {
                rectangleResponse.setIntersection(Constants.INTERSECTION);
            } else {
                rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
            }
        } else {
            rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        }
        rectangleResponse.setAdjacency(rectangle1.adjacentSharing(rectangle2));
        return rectangleResponse;
    }

}
