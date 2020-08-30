package com.learn.springboot.sblessons.springdata.associations.onetoone.repos;

import com.learn.springboot.sblessons.springdata.associations.onetoone.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
