package com.udemy.jpa.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"review","students"})
@EqualsAndHashCode(exclude = {"review","students"})
@NamedQueries(value = {
        @NamedQuery(name="test",query = "select c From Course c")
})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime created_date;

    @UpdateTimestamp
    private LocalDateTime last_updated_date;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course(String name){
        this.name=name;
    }


    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void addStudents(Student student){
        this.students.add(student);
    }
}
