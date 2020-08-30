package com.learn.springboot.sblessons.springdata.idgenerators.entities;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
public class Employee {
//    @TableGenerator(  name="employee_gen", table = "id_gen",    pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    @Id
    @GenericGenerator(name ="emp_id", strategy = "com.learn.springboot.sblessons.springdata.idgenerators.entities.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

