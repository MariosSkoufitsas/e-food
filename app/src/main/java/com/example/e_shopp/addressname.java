package com.example.e_shopp;

import java.security.PublicKey;

public class addressname {
   public static String name;
   public  static String Email;
   public  static String surename;
   public  static String phone;
   public  static String password;
   public  static double lat;
   public  static double log;


    public String getName() {
        return name;
    }

    public static double getLat() {
        return lat;
    }

    public static void setLat(double lat) {
        addressname.lat = lat;
    }

    public static double getLog() {
        return log;
    }

    public static void setLog(double log) {
        addressname.log = log;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static String getSurename() {
        return surename;
    }

    public static void setSurename(String surename) {
        addressname.surename = surename;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        addressname.phone = phone;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        addressname.password = password;
    }

    public addressname(String name) {
        this.name = name;
    }

    public addressname() {
    }

    public void setName(String name) {
        this.name = name;
    }
}
