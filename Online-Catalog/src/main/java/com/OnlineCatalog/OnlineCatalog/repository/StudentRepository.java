package com.OnlineCatalog.OnlineCatalog.repository;

import com.OnlineCatalog.OnlineCatalog.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
