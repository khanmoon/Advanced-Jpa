package com.udemy.jpa.hibernate.Repository;

import com.udemy.jpa.hibernate.Application;
import com.udemy.jpa.hibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@ContextConfiguration(classes=Application.class)
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;
    @Test
    void findById() {
        Course course = courseRepository.findById(10001L);
        assertEquals(course.getName(),"Jpa in 20 minutes");
    }
//    @Test
//    void findById() {
//    }
}