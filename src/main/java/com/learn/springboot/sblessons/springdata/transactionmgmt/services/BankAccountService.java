package com.learn.springboot.sblessons.springdata.transactionmgmt.services;

import org.springframework.stereotype.Service;

public interface BankAccountService {
    void transfer(int amount);
}
