package com.manideep.challengematrix.Model;

import java.util.ArrayList;


public class Result {

    Boolean success;
    Integer minimum;
    Boolean invalid = false;
    ArrayList<Integer> path;

    public Integer getMinimum() {
        return minimum;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public ArrayList<Integer> getPath() {
        return path;
    }

    public void setPath(ArrayList<Integer> path) {
        this.path = path;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
