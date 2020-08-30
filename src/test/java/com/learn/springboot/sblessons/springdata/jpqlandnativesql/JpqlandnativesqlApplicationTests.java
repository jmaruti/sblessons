package com.learn.springboot.sblessons.springdata.jpqlandnativesql;


import com.learn.springboot.sblessons.springdata.jpqlandnativesql.entities.Student;
import com.learn.springboot.sblessons.springdata.jpqlandnativesql.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.crypto.spec.PSource;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentCreate() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Ferguson");
        student.setScore(88L);
        studentRepository.save(student);

        student = new Student();
        student.setFirstName("Bill");
        student.setLastName("Gates");
        student.setScore(75L);
        studentRepository.save(student);

    }

    @Test
    public void testFindAllStudents() {
        System.out.println(studentRepository.findAllStudents());
    }

    @Test
    public void testFindAllStudentPartialData() {
        List<Object[]> allStudentPartialData = studentRepository.findAllStudentPartialData();
        for(Object[] obj : allStudentPartialData)
        {
            System.out.println(obj[0]);
            System.out.println(obj[1]);
        }
    }

    @Test
    public void testFndAllStudentsByFirstName() {
        System.out.println(studentRepository.findAllStudentsByFirstname("Bill"));
    }

    @Test
    public void findALlStudentsByScoreBetween() {
        System.out.println(studentRepository.findALlStudentsByScoreBetween(70L, 80l));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void deleteStudentsByFirstName() {
        studentRepository.deleteStudentsByFirstName("Bill");
        testFindAllStudents();
    }

    @Test
    public void testFindAllStudentsPageable() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        Pageable pageable = PageRequest.of(0, 4, sort);
        studentRepository.findAllStudents(pageable).forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

        sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"), new Sort.Order(Sort.Direction.DESC, "lastName"));
        pageable = PageRequest.of(0, 10, sort);
        studentRepository.findAllStudents(pageable).forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }

    @Test
    public void findAllStudentsNQ() {
        studentRepository.findAllStudentsNQ().forEach(s -> System.out.println(s.getId() + "---" + s.getFirstName() + " " + s.getLastName()));
    }

    @Test
    public void findByFirstNameNQ() {
        studentRepository.findByFirstNameNQ("Bill").forEach(s -> System.out.println(s.getId() + "---" + s.getFirstName() + " " + s.getLastName()));
    }
}
