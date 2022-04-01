package com.nuvalence.rectangle.operations;


public class RectangleService {

    public static void main(String[] args) {
        Rectangle staticRectangle = new Rectangle(new Point(1.0, 1.0), new Point(5.0, 3.0));
        Rectangle topAdjacency = new Rectangle(new Point(2.0, 3.0), new Point(4.0, 4.0));
        Rectangle topFullAdjacency = new Rectangle(new Point(1.0, 3.0), new Point(5.0, 4.0));
        Rectangle topFullOverFlow = new Rectangle(new Point(1.0, 3.0), new Point(6.0, 4.0));
        Rectangle topPartialAdjacency = new Rectangle(new Point(2.0, 3.0), new Point(6.0, 4.0));

        Rectangle containmentAdjacency = new Rectangle(new Point(1.0, 2.0), new Point(5.0, 3.0));




        RectangleServiceImplementation rectangleServiceImplementation = new RectangleServiceImplementation();
        System.out.println("top partial "+rectangleServiceImplementation.operations(staticRectangle, topAdjacency));
        System.out.println("top full "+rectangleServiceImplementation.operations(staticRectangle, topFullAdjacency));
        System.out.println("top overflow "+rectangleServiceImplementation.operations(staticRectangle, topFullOverFlow));
        System.out.println("top Partial "+rectangleServiceImplementation.operations(staticRectangle, topPartialAdjacency));


        System.out.println("Containment "+rectangleServiceImplementation.operations(staticRectangle, containmentAdjacency));





    }

}
