package com.example.consert.consert.DomainClasses;

public class Favourites {
    private int userId;
    private int aId;

    public Favourites(int userId, int aId) {
        this.userId = userId;
        this.aId = aId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }
}
