package com.learn.springboot.sblessons.clinicalsproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

    private ClinicalDataRepository clinicalDataRepository;
    private ClinicalPatientRepository  clinicalPatientRepository;

    @Autowired
    public ClinicalDataController(ClinicalDataRepository clinicalDataRepository, ClinicalPatientRepository clinicalPatientRepository) {
        this.clinicalDataRepository = clinicalDataRepository;
        this.clinicalPatientRepository = clinicalPatientRepository;
    }

    @PostMapping(value = "/clinicals")
    public ClinicalData save(@RequestBody ClinicalDataDto clinicalDataDto)
    {
        ClinicalPatient clinicalPatient =  clinicalPatientRepository.findById(clinicalDataDto.getPatientId()).get();

        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(clinicalDataDto.getComponentName());
        clinicalData.setComponentValue(clinicalDataDto.getComponentValue());
        clinicalData.setPatient(clinicalPatient);
        return clinicalDataRepository.save(clinicalData);
    }



}
