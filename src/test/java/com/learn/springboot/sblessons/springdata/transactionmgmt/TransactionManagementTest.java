package com.learn.springboot.sblessons.springdata.transactionmgmt;

import com.learn.springboot.sblessons.springdata.transactionmgmt.services.BankAccountService;
import com.learn.springboot.sblessons.springdata.transactionmgmt.services.BankAccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionManagementTest {
    @Autowired
    BankAccountService bankAccountService;
    @Test
    public void testTransaction() {
        bankAccountService.transfer(500);
    }
}
