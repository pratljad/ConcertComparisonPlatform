package com.example.consert.consert.DomainClasses;

public class Concert {
    private int cId;
    private int aId;
    private String description;
    private String concertDate;

    public Concert(int cId, int aId, String description, String concertDate) {
        this.cId = cId;
        this.aId = aId;
        this.description = description;
        this.concertDate = concertDate;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(String concertDate) {
        this.concertDate = concertDate;
    }
}
