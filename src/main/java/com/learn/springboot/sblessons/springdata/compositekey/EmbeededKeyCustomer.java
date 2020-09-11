package com.learn.springboot.sblessons.springdata.compositekey;

import javax.persistence.*;

@Entity
@Table(name = "compositekeycustomer")
public class EmbeededKeyCustomer {

    @EmbeddedId
    public EmbeddableKeyCustomerId customerId;
    private String name;

    public EmbeddableKeyCustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(EmbeddableKeyCustomerId customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
