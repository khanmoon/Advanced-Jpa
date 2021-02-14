package com.udemy.jpa.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Student {

    public Student(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

}
