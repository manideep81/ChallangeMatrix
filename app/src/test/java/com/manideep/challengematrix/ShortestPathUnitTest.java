package com.manideep.challengematrix;

import android.test.suitebuilder.annotation.SmallTest;

import com.manideep.challengematrix.View.MainActivity;

import junit.framework.TestCase;

public class ShortestPathUnitTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testCheckPathTestCase1(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{ "3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "8", "6", "4"};
        int rows=5;
        int cols=6;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase2(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "1", "2", "3"};
        int rows=5;
        int cols=6;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase3(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"19", "10", "19", "10", "19",
                "21", "23", "20", "19", "12",
                "20", "12", "20", "11", "10"};
        int rows=3;
        int cols=5;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(false, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase4(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"5", "8", "5", "3", "5"};
        int rows=1;
        int cols=5;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase5(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"5", "8", "5", "3", "5"};
        int rows=5;
        int cols=1;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase6(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"5", "4", "H",
                "8", "M", "7",
                "5", "7", "5"};
        int rows=3;
        int cols=3;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(false, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase7(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{};
        int rows=0;
        int cols=0;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(false, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase8(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"69", "10", "19", "10", "19",
                "51", "23", "20", "19", "12",
                "60", "12", "20", "11", "10"};
        int rows=3;
        int cols=5;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(false, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase9(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"60", "3", "3", "6",
                "6", "3", "7", "9",
                "5", "6", "8", "3"};
        int rows=3;
        int cols=4;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase10(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"6","3","-5","9",
                "-5","2","4","10",
                "3","-2","6","10",
                "6","-1","-2","10"};
        int rows=4;
        int cols=4;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase11(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"51", "51",
                "0", "51",
                "51", "51",
                "5", "5"};
        int rows=4;
        int cols=2;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase12(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"51", "51", "51",
                "0", "51", "51",
                "51", "51", "51",
                "5", "5", "51"};
        int rows=4;
        int cols=3;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(false, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @SmallTest
    public void testCheckPathTestCase13(){
        System.out.println("**************************** Test Case Start *******************************");
        MainActivity ma= new MainActivity();
        String[] vals= new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2"};
        int rows=2;
        int cols=20;
        boolean result= ma.checkPath(vals,rows,cols);
        assertEquals(true, result);
        System.out.println("**************************** Test Case Ended *******************************");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
