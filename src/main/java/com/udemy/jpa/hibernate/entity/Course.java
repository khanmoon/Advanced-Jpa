package com.udemy.jpa.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name="test",query = "select c From Course c")
})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime created_date;

    @UpdateTimestamp
    private LocalDateTime last_updated_date;

    public Course(String name){
        this.name=name;
    }
}
