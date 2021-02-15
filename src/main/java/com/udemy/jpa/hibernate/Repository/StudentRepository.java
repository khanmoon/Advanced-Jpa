package com.udemy.jpa.hibernate.Repository;

import com.udemy.jpa.hibernate.entity.Course;
import com.udemy.jpa.hibernate.entity.Passport;
import com.udemy.jpa.hibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;


    public Student findById(long id){
        return entityManager.find(Student.class,id);
    }



    public Student save(Student course){
        if(course.equals(null)) {
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(long id){
        Student course = findById(id);
        entityManager.remove(course);
    }

    public List<Student> namedAll(){
        TypedQuery<Student> g = entityManager.createNamedQuery("test",Student.class);
        return g.getResultList();
    }

    public Student saveStudentWithPassport(){

        Passport passport = new Passport("KR32934");

        entityManager.persist(passport);
        Student student = new Student("Todd");
        student.setPassport(passport);
        entityManager.persist(student);
        return student;
    }

    public void insertStudentCourse(long l, long l1) {

        Student student = entityManager.find(Student.class,l);
        Course course = entityManager.find(Course.class,l1);
        student.addCourses(course);

    }
}
