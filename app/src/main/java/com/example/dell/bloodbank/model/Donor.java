package com.example.dell.bloodbank.model;

/**
 * Created by dell on 9/22/2018.
 */

public class Donor {


    private int id;
    private String name;
    private String phone;
    private String address;
    private String group;


    public Donor() {
    }

    public Donor(int id, String name, String phone, String address, String group) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.group = group;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
