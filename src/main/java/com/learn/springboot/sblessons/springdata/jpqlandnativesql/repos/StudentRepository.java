package com.learn.springboot.sblessons.springdata.jpqlandnativesql.repos;


import com.learn.springboot.sblessons.springdata.jpqlandnativesql.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    // this gets all student records from the table Student
    @Query("from Student")
     List<Student> findAllStudents();

    @Query("Select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstname(@Param("firstName") String fn);

    @Query("from Student where score between :from and :to")
    List<Student> findALlStudentsByScoreBetween(@Param("from") Long fromScore, @Param("to") Long toScore);

    @Modifying
    @Query("delete from Student where firstName=:fn")
    void deleteStudentsByFirstName(@Param("fn") String firstName);

    // this gets all student records from the table Student
    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    // this gets all student records from the table Student
    @Query(value = "select id, fname, lname, score from Student", nativeQuery = true)
    List<Student> findAllStudentsNQ();

    @Query(value = "Select * from student where fname like concat('%', :fn)", nativeQuery = true)
    List<Student> findByFirstNameNQ(@Param("fn") String firstName);

}
