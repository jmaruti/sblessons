package com.learn.springboot.sblessons.springdata.idgenerators.repos;


import com.learn.springboot.sblessons.springdata.idgenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
