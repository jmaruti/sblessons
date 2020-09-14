package com.learn.springboot.sblessons.clinicalsproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClinicalPatientRepository extends JpaRepository<ClinicalPatient  , Integer> {
}
