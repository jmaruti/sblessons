package com.learn.springboot.sblessons.springdata.compositekey;

import org.springframework.data.repository.CrudRepository;

public interface EmbeddableKeyCustomerRepository
    extends CrudRepository<EmbeededKeyCustomer, CustomerId> {
}
