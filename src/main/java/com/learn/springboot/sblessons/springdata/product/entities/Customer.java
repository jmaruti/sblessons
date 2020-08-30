package com.learn.springboot.sblessons.springdata.product.entities;

import com.learn.springboot.sblessons.springdata.associations.onetomanytoone.entities.PhoneNumber;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    //@GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "firstname" )
    private String firstnm;
    private String lastname;
    private String email;
    // without cascade option, phonenumber will not get saved when custoer is saved.
    // without fetch option, there is phone numbers will not be fetched
    //@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // if fetch is removed, then @Transactional should be used.
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumberSet;

    public Set<PhoneNumber> getPhoneNumberSet() {
        return phoneNumberSet;
    }

    public void setPhoneNumberSet(Set<PhoneNumber> phoneNumberSet) {
        this.phoneNumberSet = phoneNumberSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstnm;
    }

    public void setFirstName(String firstName) {
        this.firstnm = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
}
