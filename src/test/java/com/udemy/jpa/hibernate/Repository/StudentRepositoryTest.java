package com.udemy.jpa.hibernate.Repository;

import com.udemy.jpa.hibernate.entity.Passport;
import com.udemy.jpa.hibernate.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retriveStudentAndPassport(){
        Student student = studentRepository.findById(20001L);
        log.info("Student->{}",student);
        log.info("Passport->{}",student.getPassport());


    }
    @Test
    @Transactional
    @DirtiesContext
    public void retriveStudentFromPassport(){
        Passport passport = em.find(Passport.class,40001L);
        log.info("Student->{}",passport.getPassport_number());
        log.info("Passport->{}",passport.getStudent().getName());
        passport.setPassport_number("UP12344");
        log.info("Student->{}",passport.getPassport_number());
        log.info("Passport->{}",passport.getStudent().getName());

    }
}