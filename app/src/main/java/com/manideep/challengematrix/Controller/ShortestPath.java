package com.manideep.challengematrix.Controller;

import com.manideep.challengematrix.Model.Position;
import com.manideep.challengematrix.Model.Result;

import java.util.ArrayList;



public class ShortestPath {

    static Result result = new Result(); // This will be returned as a result
    static Integer[][] matrix; // The converted matrix (1D String Array -> 2D Integer Array)
    static ArrayList<String> allPaths = new ArrayList<>(); // Stores all the unique paths

    public static Result performAction(String[] vals, int rows, int cols) {

        result.setInvalid(false);
        /* Check if the rows or cols are 0 */
        if (rows == 0 || cols == 0) {
            result.setSuccess(false);
            result.setMinimum(null);
            result.setPath(null);
            result.setInvalid(true);
            System.out.println("Invalid Matrix");
            return result;
        }

        allPaths= new ArrayList<>();

        /* Convert 1D String Array to 2D Integer Array */
        try {
            matrix = new Integer[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.valueOf(vals[i * cols + j]);
                }
            }

            System.out.println("Matrix");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("Invalid Matrix");
            result.setInvalid(true);
            result.setSuccess(false);
            result.setMinimum(null);
            result.setPath(null);
            return result;
        }

        System.out.println();

        /* Traverse the matrix to find all the possible paths */

        for (int i = 0; i < rows; i++) {

            Position position = new Position();
            position.addRowPos(i + "");
            position.setRow(i);
            position.setCol(0);
            traversePositions(position, rows, cols);

        }

        /* Find the min path */

        Integer min = null;
        Integer sum;
        Integer minPathIndex = -1;
        for (int i = 0; i < allPaths.size(); i++) {
            sum = 0;
            String[] arr= allPaths.get(i).split(" ");
            if (arr.length == cols) {
                for (int j = 0; j < arr.length; j++) {
                    sum += matrix[Integer.valueOf(arr[j])][j];
                }
                if (min == null || min > sum) {
                    min = sum;
                    minPathIndex = i;
                }
            }
        }

        ArrayList<Integer> resPath = new ArrayList<>();
        Boolean res = true;
        Integer min2 = 0;
        Integer sum2 = 0;
        String[] arr= allPaths.get(minPathIndex).split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (sum2 + matrix[Integer.valueOf(arr[i])][i] <= 50) {
                sum2 += matrix[Integer.valueOf(arr[i])][i];
                resPath.add(Integer.valueOf(arr[i]));
            } else {
                res = false;
                System.out.println("Sum greater than 50");
                break;
            }
            min2 += matrix[Integer.valueOf(arr[i])][i];
        }

        /* Return the result */
        result.setSuccess(res);
        result.setMinimum(min2);
        result.setPath(resPath);

        return result;

    }

    /* Function to traverse the whole matrix */

    public static void traversePositions(Position position, Integer rows, Integer cols) {
        Position position2;

        /* Traverse in Diagonal Up Direction */
        if ((position2 = traverseUp(position.clone(), rows, cols)) != null) {
            /* Repeat */
            traversePositions(position2, rows, cols);
        }

        /* Traverse in Forward Direction */
        if ((position2 = traverseForward(position.clone(), cols)) != null) {
            /* Repeat */
            traversePositions(position2, rows, cols);
        }

        /* Traverse in Diagonal Down Direction */
        if ((position2 = traverseDown(position.clone(), rows, cols)) != null) {
            /* Repeat */
            traversePositions(position2, rows, cols);
        }
    }

    public static Position traverseUp(Position position, Integer rows, Integer cols) {

        /* Check if the Matrix has only 2 or less cols */
        if(rows<=2) {
            return null;
        }

        /* Check if the row position is at 0, If it is then change it to the last row */
        if (position.getRow().equals(0)) {
            position.setRow(rows);
        }

        /* Check if the fully traversed in this direction */
        if (position.getCol().equals(cols - 1)) {
            /* Store the path in the allPaths ArrayList */
            if(!allPaths.contains(position.getRowPos())) {
                if(isMinimum(position.getRowPos())) {
                    allPaths.add(position.getRowPos());
                }
            }
            return null;
        } else {
            /*  Decrement the row index as it is traversing upwards
                Increment the col index as it should proceed to next col in each iteration
                Update the RowPos registration (2 Steps)
             */
            position.setRow(position.getRow() - 1);
            position.setCol(position.getCol() + 1);
            position.deleteRowPosIntegerItems(position.getCol());
            position.addRowPos(position.getRow() + "");
            return position;
        }
    }

    public static Position traverseForward(Position position, Integer cols) {

        /* Check if the fully traversed in this direction */
        if (position.getCol().equals(cols - 1)) {
            /* Store the path in the allPaths ArrayList */
            if(!allPaths.contains(position.getRowPos())) {
                if(isMinimum(position.getRowPos())) {
                    allPaths.add(position.getRowPos());
                }
            }
            return null;
        } else {
            /*
                Increment the col index as it should proceed to next col in each iteration
                Update the RowPos registration (2 Steps)
             */
            position.setCol(position.getCol() + 1);
            position.deleteRowPosIntegerItems(position.getCol());
            position.addRowPos(position.getRow() + "");

            return position;
        }
    }

    public static Position traverseDown(Position position, Integer rows, Integer cols) {

        /* Check if the Matrix has only 1 col */
        if(rows==1) {
            return null;
        }

        /* Check if the row position is at last row, If it is then reset the row counter */
        if (position.getRow().equals(rows - 1)) {
            position.setRow(-1);
        }

        /* Check if the fully traversed in this direction */
        if (position.getCol().equals(cols - 1)) {
            /* Store the path in the allPaths ArrayList */
            if(!allPaths.contains(position.getRowPos())) {
                if(isMinimum(position.getRowPos())) {
                    allPaths.add(position.getRowPos());
                }
            }
            return null;
        } else {
            /*  Increment the row index as it is traversing upwards
                Increment the col index as it should proceed to next col in each iteration
                Update the RowPos registration (2 Steps)
             */
            position.setRow(position.getRow() + 1);
            position.setCol(position.getCol() + 1);
            position.deleteRowPosIntegerItems(position.getCol());
            position.addRowPos(position.getRow() + "");
            return position;
        }
    }

    /* Check if the new path is mininum */
    public static Boolean isMinimum(String paths) {

        if(allPaths.size()>0) {
            Integer sum=0;
            Integer sum2=0;

            String[] arr = allPaths.get(0).split(" ");

            for (int i = 0; i < arr.length; i++) {
                sum+= matrix[Integer.valueOf(arr[i])][i];
            }

            arr = paths.split(" ");
            for (int i = 0; i < arr.length; i++) {
                sum2+= matrix[Integer.valueOf(arr[i])][i];
            }

            if(sum>sum2) {
                allPaths.clear();
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }


    }
}

