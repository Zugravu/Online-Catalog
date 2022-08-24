package com.OnlineCatalog.OnlineCatalog.controller;

import com.OnlineCatalog.OnlineCatalog.exception.StudentNotFoundException;
import com.OnlineCatalog.OnlineCatalog.model.Grade;
import com.OnlineCatalog.OnlineCatalog.model.Student;
import com.OnlineCatalog.OnlineCatalog.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("grades/{studentId}")
    public List<Grade> getAllGradesByStudent(@PathVariable Integer studentId)
            throws StudentNotFoundException {
        return studentService.getAllGradesByStudent(studentId);
    }

    @PutMapping("grades/add/{studentId}/{grade}")
    public void addGrade(@PathVariable Grade grade, @PathVariable Integer studentId)
            throws StudentNotFoundException {
        studentService.addGrade(grade, studentId);
    }

    @GetMapping("")
    public List<Student> getAllStudentsGradeGreaterThanEight() {
        return studentService.getAllStudentsGradeGreaterThanEight();
    }

    @GetMapping("highest-grade-student")
    public Student getHighestAverageGradeStudent() throws StudentNotFoundException {
        return studentService.getHighestAverageGradeStudent();
    }
}
