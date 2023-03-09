package com.example.usermanager.model;

public class User {
    private int id;
    private String name;
    private Province province;

    public User(int id, String name, String p_name) {
    }

    public User(int id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province = province;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
