package com.example.consert.consert.DomainClasses;

public class Takes_Place {
    private int cId;
    private int clId;

    public Takes_Place(int cId, int clId) {
        this.cId = cId;
        this.clId = clId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getClId() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId = clId;
    }
}
