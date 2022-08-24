package com.OnlineCatalog.OnlineCatalog.controller;

import com.OnlineCatalog.OnlineCatalog.exception.NoGradesException;
import com.OnlineCatalog.OnlineCatalog.exception.SpecialtyNotFoundException;
import com.OnlineCatalog.OnlineCatalog.model.Specialty;
import com.OnlineCatalog.OnlineCatalog.model.Student;
import com.OnlineCatalog.OnlineCatalog.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("all/{specialtyId}")
    public List<Student> getAllStudentBySpecialty(@PathVariable Integer specialtyId)
            throws SpecialtyNotFoundException {
        return specialtyService.getAllStudentBySpecialty(specialtyId);
    }

    @GetMapping("most-students")
    public Specialty getSpecialtyWithMostStudents() throws SpecialtyNotFoundException {
        return specialtyService.getSpecialtyWithMostStudents();
    }

    @GetMapping("average-grade/{specialtyId}")
    public Double getAverageGradeOfASpecialty(@PathVariable Integer specialtyId) throws NoGradesException, SpecialtyNotFoundException {
        return specialtyService.getAverageGradeOfASpecialty(specialtyId);
    }

    @GetMapping("highest-graded-student/{specialtyId}")
    public Student getHighestAverageGradeStudentBySpecialty(@PathVariable Integer specialsId) throws NoGradesException, SpecialtyNotFoundException {
        return specialtyService.getHighestAverageGradeStudentBySpecialty(specialsId);
    }

}
