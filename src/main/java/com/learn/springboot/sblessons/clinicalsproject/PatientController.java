package com.learn.springboot.sblessons.clinicalsproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PatientController {

    ClinicalPatientRepository clinicalPatientRepository;

    @Autowired
    public PatientController(ClinicalPatientRepository clinicalPatientRepository) {
        this.clinicalPatientRepository = clinicalPatientRepository;
    }

    @GetMapping(value = "/patients")
    public List<ClinicalPatient> getPatients() {
        return clinicalPatientRepository.findAll();
    }

    @GetMapping(value = "/patients/{id}")
    public ClinicalPatient getPatient(@PathVariable(name = "id") int id){
        return clinicalPatientRepository.findById(id).get();
    }

    @PostMapping(value = "/patients")
    public ClinicalPatient savePatient(@RequestBody ClinicalPatient patient){
        return clinicalPatientRepository.save(patient);
    }
    @GetMapping(value = "/patients/analyze/{id}")
    public ClinicalPatient analyze(@PathVariable(name = "id") int id)
    {
        ClinicalPatient clinicalPatient = clinicalPatientRepository.findById(id).get();
        List<ClinicalData> clinicalData = clinicalPatient.getClinicalData();
        Optional<ClinicalData> hwClinicalDataOpt = clinicalData.stream().filter(cd -> cd.getComponentName().equals("bmi")).findFirst();
        if (hwClinicalDataOpt.isPresent()) {
            clinicalData.remove(hwClinicalDataOpt.get());
        }

        hwClinicalDataOpt = clinicalData.stream().filter(cd -> cd.getComponentName().equals("hw")).findFirst();

        if(hwClinicalDataOpt.isPresent()) {
            ClinicalData hwClinicalData = hwClinicalDataOpt.get();
            String[] hw = hwClinicalData.getComponentValue().split("/");
            if(hw != null && hw.length > 1) {
                ClinicalData bmiData = new ClinicalData();
                bmiData.setComponentName("bmi");

                float heightInMeters = Float.parseFloat(hw[0]) * .4536F;
                float bmi = Float.parseFloat(hw[1]) / (heightInMeters * heightInMeters);
                bmiData.setComponentValue(Float.toString(bmi));
                clinicalPatient.getClinicalData().add(bmiData);
            }
        }

        return  clinicalPatient;
    }
}
