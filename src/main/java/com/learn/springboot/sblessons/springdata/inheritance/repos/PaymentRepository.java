package com.learn.springboot.sblessons.springdata.inheritance.repos;

import com.learn.springboot.sblessons.springdata.inheritance.entities.singletable.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
