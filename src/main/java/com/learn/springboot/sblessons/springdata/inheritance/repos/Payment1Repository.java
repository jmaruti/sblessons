package com.learn.springboot.sblessons.springdata.inheritance.repos;

import com.learn.springboot.sblessons.springdata.inheritance.entities.tableperclass.Payment1;
import org.springframework.data.repository.CrudRepository;

public interface Payment1Repository extends CrudRepository<Payment1, Integer> {
}
