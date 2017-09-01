package com.manideep.challengematrix;
import com.manideep.challengematrix.Model.Position;

import junit.framework.TestCase;

import org.junit.Test;


public class PositionUnitTest extends TestCase {

    Position position;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        position= new Position();
        position.addRowPos("1");
        position.addRowPos("2");
        position.addRowPos("3");
        position.addRowPos("4");
    }

    @Test
    public void testAddSubPath() {

        System.out.println("Expected Result: 1 2 3 4 ");
        System.out.println("Actual Result: " + position.getRowPos());

        assertEquals("1 2 3 4 ", position.getRowPos());
    }

    @Test
    public void testDeleteSubPath() {

        position.deleteRowPosIntegerItems(2);

        System.out.println("Expected Result: 1 2 ");
        System.out.println("Actual Result: " + position.getRowPos());

        assertEquals("1 2 ", position.getRowPos());

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        position= null;
    }
}

