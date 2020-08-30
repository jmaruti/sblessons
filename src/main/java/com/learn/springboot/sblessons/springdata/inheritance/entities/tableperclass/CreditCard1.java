package com.learn.springboot.sblessons.springdata.inheritance.entities.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard1")
public class CreditCard1 extends Payment1 {
        private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String creditcard) {
        this.cardnumber = creditcard;
    }
}
