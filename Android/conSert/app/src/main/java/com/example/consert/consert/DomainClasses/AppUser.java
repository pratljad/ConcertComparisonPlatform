package com.example.consert.consert.DomainClasses;

public class AppUser {
    private int userId;
    private String username;
    private String uPassword;

    public AppUser(int userId, String username, String uPassword) {
        this.userId = userId;
        this.username = username;
        this.uPassword = uPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}
