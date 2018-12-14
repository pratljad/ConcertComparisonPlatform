package com.example.consert.consert.DomainClasses;

public class ConcertLocation {
    private int clId;
    private int plz;
    private String country;
    private String city;
    private String adress;

    public ConcertLocation(int clId, int plz, String country, String city, String adress) {
        this.clId = clId;
        this.plz = plz;
        this.country = country;
        this.city = city;
        this.adress = adress;
    }

    public int getClId() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId = clId;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
