package com.nuvalence.rectangle.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class RectangleStater {

    static RectangleService rectangleService = new RectangleService();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        out.println("Enter the Lower Left Vertex Point (x,y)  for the first  rectangle ");
        out.println(Constants.X);
        String[] r1LowerLeft = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        Double r1lowerLeftVertexX = Double.parseDouble(r1LowerLeft[0]);
        Double r1lowerLeftVertexY = Double.parseDouble(r1LowerLeft[1]);
        Point lowerLeft = new Point(r1lowerLeftVertexX, r1lowerLeftVertexY);
        out.println("Your Lower Left Vertex coordinate is " + lowerLeft.toString());

        out.println("Enter the Top Right Vertex Point (x,y)  for the first  rectangle  ");
        String[] r1TopRight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        Double r1TopRightVertexX = Double.parseDouble(r1TopRight[0]);
        Double r1TopRightVertexY = Double.parseDouble(r1TopRight[1]);
        Point topRight = new Point(r1TopRightVertexX, r1TopRightVertexY);
        out.println("Your Lower Left Vertex coordinate is " + topRight.toString());
        Rectangle rectangle1 = new Rectangle(lowerLeft, topRight);
        out.println("Your First Rectangle is " + rectangle1.toString());

        out.println("Enter the Lower Left Vertex Point (x,y)  for the second  rectangle ");
        out.println(Constants.X);
        String[] r2LowerLeft = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        Double r2lowerLeftVertexX = Double.parseDouble(r2LowerLeft[0]);
        Double r2lowerLeftVertexY = Double.parseDouble(r2LowerLeft[1]);
        Point r2LowerLeftPoint = new Point(r2lowerLeftVertexX, r2lowerLeftVertexY);
        out.println("Your Lower Left Vertex coordinate is " + r2LowerLeftPoint.toString());

        out.println("Enter the Top Right Vertex Point (x,y)  for the second  rectangle  ");
        String[] r2TopRight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        Double r2TopRightVertexX = Double.parseDouble(r2TopRight[0]);
        Double r2TopRightVertexY = Double.parseDouble(r2TopRight[1]);
        Point r2TopRightPoint = new Point(r2TopRightVertexX, r2TopRightVertexY);
        out.println("Your Lower Left Vertex coordinate is " + r2TopRightPoint.toString());
        Rectangle rectangle2 = new Rectangle(r2LowerLeftPoint, r2TopRightPoint);
        out.println("Your Second Rectangle is " + rectangle2.toString());
        out.println("The Rectangle Operations are");
        out.println("################################################################################################################################################");
        out.println(rectangleService.operations(rectangle1, rectangle2));
        out.println("################################################################################################################################################");
        bufferedReader.close();
    }
}
