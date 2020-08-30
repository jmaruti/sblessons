package com.learn.springboot.sblessons.springdata.associations.manytomany.repos;

import com.learn.springboot.sblessons.springdata.associations.manytomany.entities.Programmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
}
