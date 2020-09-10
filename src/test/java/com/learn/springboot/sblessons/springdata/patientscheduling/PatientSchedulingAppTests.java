package com.learn.springboot.sblessons.springdata.patientscheduling;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.TestExecutionListeners;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class PatientSchedulingAppTests {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Test
    public void TestCreatePatient() {
        Patient patient = new Patient();
        patient.setFirstName("Barack");
        patient.setLastName("Obama");
        patient.setPhone("123333");

        Insurance insurance = new Insurance();
        insurance.setProviderName("Blue Cross Blue Shield");
        insurance.setCopay(20);

        patient.setInsurance(insurance);

        // created using the TestCreateDoctor
        Doctor doctor = doctorRepository.findById(1L).get();

        List<Doctor> doctorList = Arrays.asList(doctor);
        patient.setDoctors(doctorList);

        patientRepository.save(patient);
    }

    @Test
    public void TestCreateDoctor() {
       Doctor doctor = new Doctor();
       doctor.setFirstName("Bill");
       doctor.setLastName("Gates");
       doctor.setSpeciality("Alll");
       doctorRepository.save(doctor);
    }

    @Test
    public void TestCreateAppointment() {

        Appointment appointment = new Appointment();
        Timestamp appointmentTime = new Timestamp(new Date().getTime());
        appointment.setReason("I have a problem");
        appointment.setStarted(true);
        appointment.setPatient(patientRepository.findById(1L).get());
        appointment.setDoctor(doctorRepository.findById(1L).get());
        appointment.setAppointmentTime(appointmentTime );
        appointment = appointmentRepository.save(appointment);

    }

}
