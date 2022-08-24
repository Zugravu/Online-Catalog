package com.OnlineCatalog.OnlineCatalog.repository;


import com.OnlineCatalog.OnlineCatalog.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
