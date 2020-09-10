package com.learn.springboot.sblessons.springdata.patientscheduling;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
