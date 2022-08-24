package com.OnlineCatalog.OnlineCatalog.service;

import com.OnlineCatalog.OnlineCatalog.exception.ProfessorNotFoundException;
import com.OnlineCatalog.OnlineCatalog.model.Course;
import com.OnlineCatalog.OnlineCatalog.model.Professor;
import com.OnlineCatalog.OnlineCatalog.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Course> getAllCourseByProfessor(Integer professorId) throws ProfessorNotFoundException {
        Optional<Professor> tmpOptionalProfessor = professorRepository.findById(professorId);
        if (tmpOptionalProfessor.isEmpty()) {
            throw new ProfessorNotFoundException();
        } else {
            return tmpOptionalProfessor.get().getCourses();
        }
    }
}
