package com.udemy.jpa.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@ToString(exclude = {"courses","passport"})
@EqualsAndHashCode(exclude = {"courses","passport"})
public class Student {

    public Student(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Passport passport;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
    joinColumns = @JoinColumn(name="STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name= "COURSE_ID")
    )
    private Set<Course> courses = new HashSet<>();

    public void addCourses(Course course){
        this.courses.add(course);
    }

}
