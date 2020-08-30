package com.learn.springboot.sblessons.springdata.associations.onetoone.repos;

import com.learn.springboot.sblessons.springdata.associations.onetoone.entities.License;
import org.springframework.data.repository.CrudRepository;

public interface  LicenseRepository extends CrudRepository<License, Integer> {

}
