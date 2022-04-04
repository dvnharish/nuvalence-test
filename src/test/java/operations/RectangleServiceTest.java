package operations;


import com.nuvalence.rectangle.operations.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


 class RectangleServiceTest {


    RectangleService rectangleService;

    @DisplayName("Test Rectangle.noOperations()")
    @Test
    void testNoOperations() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(-6.0, -6.0), new Point(-1.0, -1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testPartialBottomAdjacent()")
    @Test
    void testSubLinelBottomAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(2.0, 0.0), new Point(3.0, 1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testPartialTopAdjacent()")
    @Test
    void testSubLineTopAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 0.5), new Point(6.0, 2.5));
        Rectangle rectangle2 = new Rectangle(new Point(3.5, 2.5), new Point(4.5, 3.5));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testPartialRightAdjacent()")
    @Test
    void testSubLineRightAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 0.5), new Point(6.0, 2.5));
        Rectangle rectangle2 = new Rectangle(new Point(6.0, 1.0), new Point(7.0, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testPartialLeftAdjacent()")
    @Test
    void testSubLineLeftAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 0.5), new Point(6.0, 2.5));
        Rectangle rectangle2 = new Rectangle(new Point(-0.5, 1.0), new Point(1.0, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }

    @DisplayName("Test Rectangle.testProperBottomAdjacent()")
    @Test
    void testProperBottomAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(1.0, -0.5), new Point(6.0, 1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testProperTopAdjacent()")
    @Test
    void testProperTopAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(-7.0, -4.0), new Point(-2.0, -2.0));
        Rectangle rectangle2 = new Rectangle(new Point(-7.0, -2.0), new Point(-2.0, -1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testProperRightAdjacent()")
    @Test
    void testProperRightAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(-7.0, 1.0), new Point(-2.0, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(-2.0, 1.0), new Point(-1.0, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testProperLeftAdjacent()")
    @Test
    void testProperLeftAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();

        Rectangle rectangle1 = new Rectangle(new Point(-6.0, -3.5), new Point(-1.5, -1.5));
        Rectangle rectangle2 = new Rectangle(new Point(-7.0, -3.5), new Point(-6.0, -1.5));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testProperInternalContainmentTopAdjacent()")
    @Test
    void testProperInternalContainmentTopAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(1.0, 2.0), new Point(5.5, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testProperInternalContainmentBottomAdjacent()")
    @Test
    void testProperInternalContainmentBottomAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testProperInternalContainmentRightAdjacent()")
    @Test
    void testProperInternalContainmentRightAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(5.0, 1.0), new Point(5.5, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testProperInternalContainmentLeftAdjacent()")
    @Test
    void testProperInternalContainmentLeftAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_PROPER);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(1.0, 1.0), new Point(1.5, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testContainmentLeftAdjacent()")
    @Test
    void testContainmentLeftAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(1.0, 1.0), new Point(2.0, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testContainmentBottomAdjacent()")
    @Test
    void testContainmentBottomAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(2.0, 1.0), new Point(3.0, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testContainmentRightAdjacent()")
    @Test
    void testContainmentRightAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(4.5, 1.0), new Point(5.0, 2.5));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testContainmentTopAdjacent()")
    @Test
    void testContainmentTopAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.5, 3.0));
        Rectangle rectangle2 = new Rectangle(new Point(3.0, 2.0), new Point(4.0, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testContainment()")
    @Test
    void testContainment() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(3.0, 2.0), new Point(4.0, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testBottomInternalAdjacentSubLineContainment()")
    @Test
    void testBottomInternalAdjacentSubLineContainment() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(2.0, 0.0), new Point(4.0, 1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testBottomPartialAdjacent()")
    @Test
    void testBottomPartialAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.PARTIAL_ADJACENT);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(2.0, 0.0), new Point(7.0, 1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testBottomOverflowAdjacent()")
    @Test
    void testBottomOverflowAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(7.0, 1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testLeftPartialAdjacent()")
    @Test
    void testLeftPartialAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.PARTIAL_ADJACENT);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testLeftOverflowAdjacent()")
    @Test
    void testLeftOverflowAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(7.0, 1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testTopOverflowAdjacent()")
    @Test
    void testTopOverflowAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 4.0), new Point(7.0, 5.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testTopPartialAdjacent()")
    @Test
    void testTopPartialAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.PARTIAL_ADJACENT);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 4.0), new Point(3.0, 5.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testRightOverflowAdjacent()")
    @Test
    void testRightOverflowAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(6.0, 0.0), new Point(8.0, 5.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testRightPartialAdjacent()")
    @Test
    void testRightPartialAdjacent() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.PARTIAL_ADJACENT);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(6.0, 0.0), new Point(8.0, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testBottomIntersection()")
    @Test
    void testBottomIntersection() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(2.0, 0.0), new Point(5.0, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }

    @DisplayName("Test Rectangle.testTopIntersection()")
    @Test
    void testTopIntersection() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(2.0, 3.0), new Point(3.0, 5.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testRightIntersection()")
    @Test
    void testRightIntersection() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(5.5, 1.5), new Point(7.0, 3.5));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testLeftIntersection()")
    @Test
    void testLeftIntersection() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.5, 1.5), new Point(2.0, 3.5));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }

    @DisplayName("Test Rectangle.testLeftIntersection()")
    @Test
    void testInternalLeftSubLine() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(1.0, 2.0), new Point(2.0, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }

    @DisplayName("Test Rectangle.testInternalRightSubLine()")
    @Test
    void testInternalRightSubLine() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(5.0, 2.0), new Point(6.0, 3.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testInternalRightSubLine()")
    @Test
    void testInternalTopSubLine() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(3.0, 3.0), new Point(4.0, 4.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }

    @DisplayName("Test Rectangle.testInternalBottomSubLine()")
    @Test
    void testInternalBottomSubLine() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.INTERNAL + "" + Constants.ADJACENT_SUB_LINE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(3.0, 1.0), new Point(4.0, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testCornerIntersection()")
    @Test
    void testCornerIntersection() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(5.0, 0.0), new Point(7.0, 2.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }

    @DisplayName("Test Rectangle.testRectangleTwoOverlappingRectangleOne()")
    @Test
    void testRectangleTwoOverlappingRectangleOne() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.NOT_ADJACENT);
        rectangleResponse.setIntersection(Constants.INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(8.0, 8.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }

    @DisplayName("Test Rectangle.testBottomLeftVertex()")
    @Test
    void testBottomLeftVertex() {
        RectangleResponse rectangleResponse = new RectangleResponse();
        rectangleResponse.setAdjacency(Constants.VERTEX_SHARE);
        rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
        rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
        this.rectangleService = new RectangleService();
        Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(6.0, 4.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 1.0));
        assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
    }


    @DisplayName("Test Rectangle.testNegativeTestCases()")
    @Test
    void testNegativeTestCases() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new Point(0.0, 0.0), new Point(-1.0, 1.0));
        }, "Invalid rectangle");

        Assertions.assertEquals("Invalid rectangle", thrown.getMessage());
    }


    @DisplayName("Test Rectangle.testNegativeTestCasesNanY()")
    @Test
    void testNegativeTestCasesNanY() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new Point(0.0, 0.0), new Point(-1.0, Double.NaN));
        }, "Y-coordinates cannot be NaN");

        Assertions.assertEquals("Y-coordinates cannot be NaN", thrown.getMessage());
    }

    @DisplayName("Test Rectangle.testNegativeTestCasesNanX()")
    @Test
    void testNegativeTestCasesNanX() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new Point(Double.NaN, 0.0), new Point(-1.0, 0.0));
        }, "X-coordinates cannot be NaN");

        Assertions.assertEquals("X-coordinates cannot be NaN", thrown.getMessage());
    }

    @DisplayName("Test Rectangle.testHashCode()")
    @Test
    void testRectangleHashCode() {
        Rectangle rectangle1 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Assertions.assertEquals(rectangle1.hashCode(), rectangle2.hashCode());
    }

    @DisplayName("Test Rectangle.testEquals()")
    @Test
    void testRectangleEquals() {
        Rectangle rectangle1 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Assertions.assertEquals(rectangle1.equals(rectangle2), rectangle1.hashCode() == rectangle2.hashCode());
    }


    @DisplayName("Test Rectangle.testHashCode()")
    @Test
    void testPointHashCode() {
        Point p1 = new Point(0.0, 5.0);
        Point p2 = new Point(0.0, 5.0);
        Assertions.assertEquals(p1.hashCode(), p2.hashCode());
    }

    @DisplayName("Test Rectangle.testPointEquals()")
    @Test
    void testPointEquals() {
        Point p1 = new Point(0.0, 5.0);
        Point p2 = new Point(0.0, 5.0);
        Assertions.assertEquals(p1.equals(p2), p1.hashCode() == p2.hashCode());
    }


    @DisplayName("Test Rectangle.testLineHashCode()")
    @Test
    void testLineHashCode() {
        Line l1 = new Line(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Line l2 = new Line(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Assertions.assertEquals(l1.hashCode(), l2.hashCode());
    }

    @DisplayName("Test Rectangle.testLineEquals()")
    @Test
    void testLineEquals() {
        Line l1 = new Line(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Line l2 = new Line(new Point(0.0, 0.0), new Point(1.0, 1.0));
        Assertions.assertEquals(l1.equals(l2), l1.hashCode() == l2.hashCode());
    }

     @DisplayName("Test Rectangle.testRightSemiOverflow()")
     @Test
     void testRightSemiOverflow() {
         RectangleResponse rectangleResponse = new RectangleResponse();
         rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
         rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
         rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
         this.rectangleService = new RectangleService();
         Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(3.0, 3.0));
         Rectangle rectangle2 = new Rectangle(new Point(3.0, 0.0), new Point(4.0, 3.0));
         assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
     }

     @DisplayName("Test Rectangle.testBottomSemiOverflow()")
     @Test
     void testBottomSemiOverflow() {
         RectangleResponse rectangleResponse = new RectangleResponse();
         rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
         rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
         rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
         this.rectangleService = new RectangleService();
         Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(3.0, 3.0));
         Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(3.0, 1.0));
         assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));
     }


     @DisplayName("Test Rectangle.testTopOverflow()")
     @Test
     void testTopOverflow() {
         RectangleResponse rectangleResponse = new RectangleResponse();
         rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
         rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
         rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
         this.rectangleService = new RectangleService();
         Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(3.0, 3.0));
         Rectangle rectangle2 = new Rectangle(new Point(1.0, 3.0), new Point(4.0, 4.0));
         assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));

     }


     @DisplayName("Test Rectangle.testLeftOverflow()")
     @Test
     void testLeftOverflow() {
         RectangleResponse rectangleResponse = new RectangleResponse();
         rectangleResponse.setAdjacency(Constants.ADJACENT_OVERFLOW);
         rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
         rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
         this.rectangleService = new RectangleService();
         Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(3.0, 3.0));
         Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 3.0));
         assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));

     }


     @DisplayName("Test Rectangle.testLeftPartialAdjacency()")
     @Test
     void testLeftPartialAdjacency() {
         RectangleResponse rectangleResponse = new RectangleResponse();
         rectangleResponse.setAdjacency(Constants.PARTIAL_ADJACENT);
         rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
         rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
         this.rectangleService = new RectangleService();
         Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(3.0, 3.0));
         Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(1.0, 2.0));
         assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));

     }

     @DisplayName("Test Rectangle.testOverlappingRectangles()")
     @Test
     void testOverlappingRectangles() {
         RectangleResponse rectangleResponse = new RectangleResponse();
         rectangleResponse.setAdjacency(Constants.INTERNAL+Constants.ADJACENT_OVERFLOW);
         rectangleResponse.setContainment(Constants.NO_CONTAINMENT);
         rectangleResponse.setIntersection(Constants.INTERSECTION);
         this.rectangleService = new RectangleService();
         Rectangle rectangle1 = new Rectangle(new Point(1.0, 1.0), new Point(5.0, 3.0));
         Rectangle rectangle2 = new Rectangle(new Point(0.0, 0.0), new Point(5.0, 3.0));
         assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));

     }

     @DisplayName("Test Rectangle.testOverlappingRectanglesOpposite()")
     @Test
     void testOverlappingRectanglesOpposite() {
         RectangleResponse rectangleResponse = new RectangleResponse();
         rectangleResponse.setAdjacency(Constants.INTERNAL+Constants.ADJACENT_SUB_LINE);
         rectangleResponse.setContainment(Constants.CONTAINMENT);
         rectangleResponse.setIntersection(Constants.NO_INTERSECTION);
         this.rectangleService = new RectangleService();
         Rectangle rectangle2 = new Rectangle(new Point(1.0, 1.0), new Point(5.0, 3.0));
         Rectangle rectangle1 = new Rectangle(new Point(0.0, 0.0), new Point(5.0, 3.0));
         assertEquals(rectangleResponse, this.rectangleService.operations(rectangle1, rectangle2));

     }

}
