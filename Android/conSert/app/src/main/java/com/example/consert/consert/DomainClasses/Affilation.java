package com.example.consert.consert.DomainClasses;

public class Affilation {
    private int aId;
    private int gId;

    public Affilation(int aId, int gId) {
        this.aId = aId;
        this.gId = gId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }
}
