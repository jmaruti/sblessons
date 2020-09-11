package com.learn.springboot.sblessons.springdata.compositekey;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CustomerId.class)
@Table(name = "compositekeycustomer")
public class CompositeKeyCustomer {
    @Id
    private int id;
    @Id
    private String email;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
