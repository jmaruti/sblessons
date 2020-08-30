package com.learn.springboot.sblessons.springdata.inheritance.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bankcheck2")
@PrimaryKeyJoinColumn(name = "id")
public class CheckJoined extends PaymentJoined  {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
