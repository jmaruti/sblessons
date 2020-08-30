package com.learn.springboot.sblessons.springdata.associations;

import com.learn.springboot.sblessons.springdata.associations.onetomanytoone.entities.PhoneNumber;
import com.learn.springboot.sblessons.springdata.associations.onetomanytoone.repos.CustomerOneToOneManyRepository;
import com.learn.springboot.sblessons.springdata.product.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class AssociationsTest {
@Autowired
    CustomerOneToOneManyRepository customerOneToOneManyRepository;

    @Test
    public void testOneToOneMany() {

        Customer customer = new Customer();
        customer.setId(2);
        customer.setFirstName("JOhn");
        customer.setLastName("Beaver");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber("123456");
        Set<PhoneNumber> phoneNumberSet = new HashSet<>();
        phoneNumberSet.add(phoneNumber);
        customer.setPhoneNumberSet(phoneNumberSet);

        phoneNumber.setCustomer(customer);
        customerOneToOneManyRepository.save(customer);

    }

    @Test
    @Transactional
    public void testReadCustomer() {
            Customer customer = (Customer) customerOneToOneManyRepository.findById(Integer.valueOf(2)).get();
        System.out.println(customer.getLastName());
        Set<PhoneNumber> phoneNumberSet = customer.getPhoneNumberSet();
        phoneNumberSet.forEach(phoneNumber -> System.out.println(phoneNumber.getNumber()));
        customer.setLastName("Bush");
        Set<PhoneNumber> phoneNumbers = customer.getPhoneNumberSet();
        phoneNumbers.forEach(phoneNumber ->{
            phoneNumber.setNumber("111111");
            phoneNumber.setPhonetype("cell");
        });

        customerOneToOneManyRepository.save(customer);

    }
}
