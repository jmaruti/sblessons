package com.learn.springboot.sblessons.springdata.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompositeKeyAppTest {

    @Autowired
    CompositeKeyCustomerRepository compositeKeyCustomerRepository;
    @Test
    void testCreate() {
        CompositeKeyCustomer customer = new CompositeKeyCustomer();
        customer.setId(1234);
        customer.setEmail("test@test.com");
        customer.setName("Bill Gates");
        compositeKeyCustomerRepository.save(customer);

    }
}
