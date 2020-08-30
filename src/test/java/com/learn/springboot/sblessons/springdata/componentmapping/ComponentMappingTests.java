package com.learn.springboot.sblessons.springdata.componentmapping;

import com.learn.springboot.sblessons.springdata.componentmapping.entities.Address;
import com.learn.springboot.sblessons.springdata.componentmapping.entities.EmployeeCompMapping;
import com.learn.springboot.sblessons.springdata.componentmapping.repos.EmployeeCompMappingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentMappingTests {
    @Autowired
    EmployeeCompMappingRepository employeeCompMappingRepository;

    @Test
    public void testCreateEmployeeComponentMapping() {
        EmployeeCompMapping employeeCompMapping = new EmployeeCompMapping();
        employeeCompMapping.setId(2);
        employeeCompMapping.setName("Jay Jaganathan");
        Address address = new Address();
        address.setCity("Lorton");
        address.setState("VA");
        address.setCountry("USA");
        employeeCompMapping.setAddress(address);
        employeeCompMappingRepository.save(employeeCompMapping);
    }
}
