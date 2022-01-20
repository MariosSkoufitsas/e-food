package com.example.e_shopp;

public class Member {
    private String Name;
    private int Age;
    private Long ph;
    private Float ht;

    public Member() {
    }

    public Member(String name, int age, Long ph, Float ht) {
        Name = name;
        Age = age;
        this.ph = ph;
        this.ht = ht;
    }

    @Override
    public String toString() {
        return "Member{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", ph=" + ph +
                ", ht=" + ht +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Long getPh() {
        return ph;
    }

    public void setPh(Long ph) {
        this.ph = ph;
    }

    public Float getHt() {
        return ht;
    }

    public void setHt(Float ht) {
        this.ht = ht;
    }
}
