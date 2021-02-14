package com.udemy.jpa.hibernate.Repository;

import com.udemy.jpa.hibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;


    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }


    public Course save(Course course){
        if(course.getId()==null) {
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public List<Course> namedAll(){
        TypedQuery<Course> g = entityManager.createNamedQuery("test",Course.class);
        return g.getResultList();
    }

}
