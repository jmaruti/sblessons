package com.learn.springboot.sblessons.springdata.inheritance;

import com.learn.springboot.sblessons.springdata.inheritance.entities.CheckJoined;
import com.learn.springboot.sblessons.springdata.inheritance.entities.CreditCardJoined;
import com.learn.springboot.sblessons.springdata.inheritance.entities.singletable.Check;
import com.learn.springboot.sblessons.springdata.inheritance.entities.singletable.CreditCard;
import com.learn.springboot.sblessons.springdata.inheritance.entities.tableperclass.Check1;
import com.learn.springboot.sblessons.springdata.inheritance.entities.tableperclass.CreditCard1;
import com.learn.springboot.sblessons.springdata.inheritance.repos.Payment1Repository;
import com.learn.springboot.sblessons.springdata.inheritance.repos.PaymentRepository;
import com.learn.springboot.sblessons.springdata.inheritance.repos.joined.PaymentJoinedRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InheritanceTests {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    Payment1Repository payment1Repository;

    @Autowired
   PaymentJoinedRepository paymentJoinedRepository;

    @Test
    // this tests the single_table strategy
    public void testCreateCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(11);
        creditCard.setAmount(10);
        ((CreditCard)creditCard).setCardnumber("2345");
        paymentRepository.save(creditCard);
    }

    @Test
    // this tests the single_table strategy
    public void testCreateCheck() {
        Check check = new Check();
        check.setId(12);
        check.setAmount(12);
        check.setChecknumber("4321");
        paymentRepository.save(check);
    }

    @Test
    // this tests the table_per_class strategy
    public void testCreateCreditCard1() {
        CreditCard1 creditCard1 = new CreditCard1();
        creditCard1.setId(11);
        creditCard1.setAmount(10);
        creditCard1.setCardnumber("2345");
        payment1Repository.save(creditCard1);
    }

    @Test
    // this tests the table_per_class strategy
    public void testCreateCheck1() {
        Check1 check = new Check1();
        check.setId(12);
        check.setAmount(12);
        check.setChecknumber("4321");
        payment1Repository.save(check);
    }

    @Test
    // this tests the joined strategy
    public void testCreateCreditCardJoined() {
        CreditCardJoined creditCardJoined = new
            CreditCardJoined();
        creditCardJoined.setId(11);
        creditCardJoined.setAmount(10);
        creditCardJoined.setCardnumber("2345");
        paymentJoinedRepository.save(creditCardJoined);
    }

    @Test
    // this tests the joined strategy
    public void testBankCheckJoined() {
        CheckJoined checkJoined = new  CheckJoined();
        checkJoined.setId(12);
        checkJoined.setAmount(10);
        checkJoined.setChecknumber("654321");
        paymentJoinedRepository.save(checkJoined);
    }
}
