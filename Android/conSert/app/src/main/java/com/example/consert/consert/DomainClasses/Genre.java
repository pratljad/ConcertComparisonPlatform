package com.example.consert.consert.DomainClasses;

public class Genre {
    private int gId;
    private String description;


    public Genre(int gId, String description) {
        this.gId = gId;
        this.description = description;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
