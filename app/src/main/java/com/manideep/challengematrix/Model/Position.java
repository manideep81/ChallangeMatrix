package com.manideep.challengematrix.Model;

import java.util.ArrayList;

public class Position implements Cloneable {

    Integer row;
    Integer col;
    String rowPos="";

    public void deleteRowPosIntegerItems(Integer pos) {
        if(!this.rowPos.equals("")) {
            String[] arr= this.rowPos.split(" ");
            String temp="";
            for (int i = 0; i < pos; i++) {
                temp+= arr[i] + " ";
            }
            this.rowPos= temp;
        }
    }

    public void addRowPos(String rowPos) {
        this.rowPos+=rowPos + " ";
    }

    public String getRowPos() {
        return rowPos;
    }

    public void setRowPos(String rowPos) {
        this.rowPos = rowPos;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Position clone() {
        try {
            return (Position) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

