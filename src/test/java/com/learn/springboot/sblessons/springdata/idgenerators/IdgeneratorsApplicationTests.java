package com.learn.springboot.sblessons.springdata.idgenerators;

import com.learn.springboot.sblessons.springdata.idgenerators.entities.Employee;
import com.learn.springboot.sblessons.springdata.idgenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void testCreateEmpl() {
        Employee employee = new Employee();
        employee.setId(123L);
        employee.setName("Jay Jaganathan");
        employeeRepository.save(employee);
    }

    @Test
    void testCreateEmpl1() {
        Employee employee = new Employee();
        employee.setName("Jay Jaganathan2");
        employeeRepository.save(employee);
    }

}
