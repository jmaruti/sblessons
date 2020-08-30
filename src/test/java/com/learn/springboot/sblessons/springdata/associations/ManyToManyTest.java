package com.learn.springboot.sblessons.springdata.associations;

import com.learn.springboot.sblessons.springdata.associations.manytomany.entities.Programmer;
import com.learn.springboot.sblessons.springdata.associations.manytomany.entities.Project;
import com.learn.springboot.sblessons.springdata.associations.manytomany.repos.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class ManyToManyTest {

    @Autowired
    ProgrammerRepository programmerRepository;

    @Test
    public void testManyToMany() {
        Programmer programmer = new Programmer();
        programmer.setName("Jay Jaganathan");
        programmer.setSal(1000);
        Set<Project> projects = new HashSet<>();
        Project project= new Project();
        project.setName("Hibernate");
        projects.add(project);
        programmer.setProjects(projects);
        programmerRepository.save(programmer);
    }
@Test
@Transactional
    public void testFindManyToManyProgrammer() {
        Programmer programmer = (Programmer) programmerRepository.findById(1).get();
        System.out.println(programmer);
    System.out.println(programmer.getProjects());
    }
}
