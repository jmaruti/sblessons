package com.learn.springboot.sblessons.springdata.inheritance.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard2")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCardJoined extends PaymentJoined  {
        private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String creditcard) {
        this.cardnumber = creditcard;
    }
}
