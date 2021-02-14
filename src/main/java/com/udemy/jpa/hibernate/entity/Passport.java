package com.udemy.jpa.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Passport {

    Passport(String number){
        this.passport_number = passport_number;
    }
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String passport_number;
}
