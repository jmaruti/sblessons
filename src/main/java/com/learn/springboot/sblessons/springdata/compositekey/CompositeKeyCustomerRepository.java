package com.learn.springboot.sblessons.springdata.compositekey;

import org.springframework.data.repository.CrudRepository;

public interface CompositeKeyCustomerRepository
    extends CrudRepository<CompositeKeyCustomer, CustomerId> {
}
