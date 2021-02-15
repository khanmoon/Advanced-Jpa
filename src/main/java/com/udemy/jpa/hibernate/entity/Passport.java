package com.udemy.jpa.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Passport {

    public Passport(String passport_number){
        this.passport_number = passport_number;
    }
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String passport_number;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;
}
