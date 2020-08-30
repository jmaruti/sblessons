package com.learn.springboot.sblessons.springdata.inheritance.entities;

import javax.persistence.*;

@Entity
@Table(name = "payment2")
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class PaymentJoined {
    @Id
    private Integer id;
    private double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
