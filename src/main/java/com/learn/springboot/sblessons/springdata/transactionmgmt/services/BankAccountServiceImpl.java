package com.learn.springboot.sblessons.springdata.transactionmgmt.services;

import com.learn.springboot.sblessons.springdata.transactionmgmt.entities.BankAccount;
import com.learn.springboot.sblessons.springdata.transactionmgmt.repos.BankAcctRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAcctRepository bankAcctRepository;

    @Override
    @Transactional
    public void transfer(int amount) {
        BankAccount obamaAccount = bankAcctRepository.findById(1).get();
        BankAccount trumpAccount = bankAcctRepository.findById(2).get();

        obamaAccount.setBal(obamaAccount.getBal() - amount) ;
        bankAcctRepository.save(obamaAccount);

        if(true) throw new RuntimeException();

        trumpAccount.setBal(trumpAccount.getBal() + amount);
        bankAcctRepository.save(trumpAccount);



    }
}
