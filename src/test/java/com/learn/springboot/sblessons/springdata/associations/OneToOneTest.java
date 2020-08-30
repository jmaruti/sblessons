package com.learn.springboot.sblessons.springdata.associations;

import com.learn.springboot.sblessons.springdata.associations.onetoone.entities.License;
import com.learn.springboot.sblessons.springdata.associations.onetoone.entities.Person;
import com.learn.springboot.sblessons.springdata.associations.onetoone.repos.LicenseRepository;
import com.learn.springboot.sblessons.springdata.associations.onetoone.repos.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class OneToOneTest {

    @Autowired
    LicenseRepository licenseRepository;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void testOneToOne() {
        Person person = new Person();
        person.setFirstName("Bill");
        person.setLastName("Clinton");
        person.setAge(100);

        License license = new License();
        license.setType("CAR");
        license.setValidFrom(new Date());
        license.setValidTo(new Date());

        license.setPerson(person);
        licenseRepository.save(license);
    }
}
