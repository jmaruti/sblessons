package com.learn.springboot.sblessons.springdata.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmbeddableKeyAppTest {

    @Autowired
    EmbeddableKeyCustomerRepository embeddableKeyCustomerRepository;


    @Test
    void testCreate() {
        EmbeededKeyCustomer embeededKeyCustomer = new EmbeededKeyCustomer();
        EmbeddableKeyCustomerId embeddableKeyCustomerId = new EmbeddableKeyCustomerId();
        embeddableKeyCustomerId.setId(6789);
        embeddableKeyCustomerId.setEmail("Test@Test.com");
        embeededKeyCustomer.setCustomerId(embeddableKeyCustomerId);
        embeededKeyCustomer.setName("Bill Gates");
        embeddableKeyCustomerRepository.save(embeededKeyCustomer);

    }
}
