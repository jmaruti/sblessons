package com.learn.springboot.sblessons.springdata.transactionmgmt.repos;

import com.learn.springboot.sblessons.springdata.transactionmgmt.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAcctRepository extends CrudRepository<BankAccount, Integer> {
}
