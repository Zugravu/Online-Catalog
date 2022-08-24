package com.OnlineCatalog.OnlineCatalog.repository;

import com.OnlineCatalog.OnlineCatalog.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
