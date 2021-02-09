package com.udemy.jpa.hibernate;

import com.udemy.jpa.hibernate.Repository.CourseRepository;
import com.udemy.jpa.hibernate.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
    @Autowired
    CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
//        courseRepository.deleteById(10001L);
        log.info("Course Found {}",courseRepository.findById(10001L));
        courseRepository.save(new Course("MicroService in Hundred Steps"));

    }
}
