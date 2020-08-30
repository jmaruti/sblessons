package com.learn.springboot.sblessons.springdata.associations.onetomanytoone.repos;

import com.learn.springboot.sblessons.springdata.product.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerOneToOneManyRepository extends CrudRepository<Customer, Integer> {
}
