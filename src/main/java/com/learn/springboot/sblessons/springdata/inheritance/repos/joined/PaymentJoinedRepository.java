package com.learn.springboot.sblessons.springdata.inheritance.repos.joined;


import com.learn.springboot.sblessons.springdata.inheritance.entities.PaymentJoined;
import org.springframework.data.repository.CrudRepository;

public interface PaymentJoinedRepository extends CrudRepository<PaymentJoined, Integer> {

}
