package com.nuvalence.rectangle.operations;

public class RectangleServiceImplementation {


    public String operations(Rectangle rectangle1, Rectangle rectangle2) {
        StringBuilder str = new StringBuilder();
        str.append(Constants.CONTAINMENT + "  ").append(rectangle1.contains(rectangle2));
        str.append("\t" + Constants.INTERSECTION + "  ");
        if (rectangle1.isIntersecting(rectangle2)) {
            str.append("\t" + Constants.INTERSECTION + " - No " + Constants.CONTAINMENT);
        } else {
            str.append("\tNo " + Constants.INTERSECTION + " ");
        }
        str.append("\t" + Constants.ADJACENCY + " ").append(rectangle1.sharing(rectangle2));
        return str.toString();
    }

}
