package com.manideep.challengematrix;
import com.manideep.challengematrix.Controller.ShortestPath;
import com.manideep.challengematrix.Model.Position;

import junit.framework.TestCase;


public class ControllerUnitTest extends TestCase {

    ShortestPath shortestPath;
    Position position;
    int rows;
    int cols;
    String res="";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        /* Initialize all the desired parameters */
        res="";
        shortestPath = new ShortestPath();

        position = new Position();
        position.addRowPos(0 + "");
        position.setRow(0);
        position.setCol(0);

        rows = 5;
        cols = 6;
    }

    public void testTraverseUp() {

        /* Perform the traverse */
        for (int i = 0; i < rows; i++) {
            position = shortestPath.traverseUp(position, rows, cols);
            System.out.println(position.getRowPos());
            res= position.getRowPos();
        }

        assertEquals("0 4 3 2 1 0 ", res);

    }

    public void testTraverseForward() {

        /* Perform the traverse */
        for (int i = 0; i < rows; i++) {
            position = shortestPath.traverseForward(position, cols);
            System.out.println(position.getRowPos());
            res= position.getRowPos();
        }

        assertEquals("0 0 0 0 0 0 ", res);

    }

    public void testTraverseDown() {

        /* Perform the traverse */
        for (int i = 0; i < rows; i++) {
            position = shortestPath.traverseDown(position, rows, cols);
            System.out.println(position.getRowPos());
            res= position.getRowPos();
        }

        assertEquals("0 1 2 3 4 0 ", res);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

