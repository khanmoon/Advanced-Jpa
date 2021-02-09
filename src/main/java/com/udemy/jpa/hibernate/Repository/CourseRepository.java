package com.udemy.jpa.hibernate.Repository;

import com.udemy.jpa.hibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager entityManager;


    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }


//    public Course save(Course course){
//
//    }

    public void deleteById(long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

}
