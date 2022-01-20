package com.example.e_shopp;

public class atomo {
    String username;
    String email;
    String phone;
    String Homeaddres;
    double Lat;
    double Log;

    public atomo() {
    }

    public atomo(String username, String email, String phone, String homeaddres, double lat, double log) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        Homeaddres = homeaddres;
        Lat = lat;
        Log = log;
    }

    public atomo(String username, String email, String phone, String homeaddres) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        Homeaddres = homeaddres;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLog() {
        return Log;
    }

    public void setLog(double log) {
        Log = log;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeaddres() {
        return Homeaddres;
    }

    public void setHomeaddres(String homeaddres) {
        Homeaddres = homeaddres;
    }
}
