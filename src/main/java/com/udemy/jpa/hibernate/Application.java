package com.udemy.jpa.hibernate;

import com.udemy.jpa.hibernate.Repository.CourseRepository;
import com.udemy.jpa.hibernate.Repository.StudentRepository;
import com.udemy.jpa.hibernate.entity.Course;
import com.udemy.jpa.hibernate.entity.Review;
import com.udemy.jpa.hibernate.entity.Student;
import com.udemy.jpa.hibernate.entity.Test;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
//        courseRepository.deleteById(10001L);
//        log.info("Course Found {}",courseRepository.namedAll());
//        courseRepository.save(new Course("MicroService in Hundred Steps"));
//        studentRepository.saveStudentWithPassport();
//        courseRepository.addReviews();
//        Review review = em.find(Review.class,31L);
//        log.info("Reviews are -> {}", review.getRating());
//
//        studentRepository.insertStudentCourse(20001L,10003L);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        TypedQuery<Course> typedQuery = em.createQuery(cq.select(courseRoot));
        log.info("Typed Query -> {}",typedQuery.getResultList().get(0).getName());
//        Student cc = em.find(Student.class,20001L);
//        log.info("Course -> {}", cc);
//        log.info("test {}",review.toString());

    }

}
