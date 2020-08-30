package com.learn.springboot.sblessons.springdata.componentmapping.repos;

import com.learn.springboot.sblessons.springdata.componentmapping.entities.EmployeeCompMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCompMappingRepository extends CrudRepository<EmployeeCompMapping, Integer> {
}
