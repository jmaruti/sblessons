package com.learn.springboot.sblessons.springdata.compositekey;


import java.io.Serializable;

// all composite key classes should implement Serializable interface
public class CustomerId implements Serializable {

private int id;
private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
