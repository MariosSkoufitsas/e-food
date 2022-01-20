package com.example.e_shopp;

public class pgilika {
    private String name;
    private String yliko1="";
    private String yliko2="";
    private String yliko3="";
    private String yliko4="";
    private String yliko5="";
    private double price;
    private  int Posothta;

    public pgilika(String name, String yliko1, String yliko2, String yliko3, String yliko4, String yliko5, double price, int posothta) {
        this.name = name;
        this.yliko1 = yliko1;
        this.yliko2 = yliko2;
        this.yliko3 = yliko3;
        this.yliko4 = yliko4;
        this.yliko5 = yliko5;
        this.price = price;
        this.Posothta = posothta;
    }

    public pgilika() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getYliko1() {
        return yliko1;
    }

    public void setYliko1(String yliko1) {
        this.yliko1 = yliko1;
    }

    public String getYliko2() {
        return yliko2;
    }

    public void setYliko2(String yliko2) {
        this.yliko2 = yliko2;
    }

    public String getYliko3() {
        return yliko3;
    }

    public void setYliko3(String yliko3) {
        this.yliko3 = yliko3;
    }

    public String getYliko4() {
        return yliko4;
    }

    public void setYliko4(String yliko4) {
        this.yliko4 = yliko4;
    }

    public String getYliko5() {
        return yliko5;
    }

    public void setYliko5(String yliko5) {
        this.yliko5 = yliko5;
    }

    public int getPosothta() {
        return Posothta;
    }

    public void setPosothta(int posothta) {
        Posothta = posothta;
    }

    @Override
    public String toString() {
        return
                 name + "  " +
                 yliko1 + "   " +
                 yliko2 + "  " +
                 yliko3 + "  " +
                 yliko4 + "  " +
                         yliko5 + "  "+

                 " Ποσότητα: "+Posothta+" Τιμή: "+price;
    }
}
