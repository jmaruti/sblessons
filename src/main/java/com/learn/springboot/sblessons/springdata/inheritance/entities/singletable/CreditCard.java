package com.learn.springboot.sblessons.springdata.inheritance.entities.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "cc")
public class CreditCard extends Payment {
        private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String creditcard) {
        this.cardnumber = creditcard;
    }
}
