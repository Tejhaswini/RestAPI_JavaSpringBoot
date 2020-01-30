package com.springbootrestapi.model.repository;

import  com.springbootrestapi.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CoursesRepository extends JpaRepository<Courses, Long>{

}
