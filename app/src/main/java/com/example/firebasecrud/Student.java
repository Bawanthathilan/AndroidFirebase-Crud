package com.example.firebasecrud;

import android.content.Intent;

public class Student {

    private  String ID;
    private String name;
    private String address;
    private Integer conNo;

    public Student(String ID, String name, String address, Integer conNo) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.conNo = conNo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getConNo() {
        return conNo;
    }

    public void setConNo(Integer conNo) {
        this.conNo = conNo;
    }
}
