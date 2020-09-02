package com.learn.springboot.sblessons.springdata.transactionmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccount")
public class BankAccount {

    @Id
    private Integer accno;
    @Column(name = "lastname")
    private String last_name;
    @Column(name = "firstname")
    private String first_name;
    private int bal;

    public Integer getAccno() {
        return accno;
    }

    public void setAccno(Integer acctno) {
        this.accno = acctno;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
            ", acctno='" + accno + '\'' +
            ", last_name='" + last_name + '\'' +
            ", first_name='" + first_name + '\'' +
            ", bal=" + bal +
            '}';
    }
}
