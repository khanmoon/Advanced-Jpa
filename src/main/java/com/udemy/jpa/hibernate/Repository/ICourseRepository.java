package com.udemy.jpa.hibernate.Repository;

import com.udemy.jpa.hibernate.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICourseRepository extends PagingAndSortingRepository<Course,Long> {
}
