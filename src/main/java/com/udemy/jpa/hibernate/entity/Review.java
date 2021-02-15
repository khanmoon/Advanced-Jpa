package com.udemy.jpa.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Review {
    private String rating;
    private String description;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    private Course course;

    public Review(String rating, String description){
        this.rating = rating;
        this.description = description;
    }
}
