package com.OnlineCatalog.OnlineCatalog.service;

import com.OnlineCatalog.OnlineCatalog.exception.NoGradesException;
import com.OnlineCatalog.OnlineCatalog.exception.StudentNotFoundException;
import com.OnlineCatalog.OnlineCatalog.model.Grade;
import com.OnlineCatalog.OnlineCatalog.model.Student;
import com.OnlineCatalog.OnlineCatalog.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void addGrade(Grade grade, Integer studentId) throws StudentNotFoundException {
        Optional<Student> tmpOptionalStudent = studentRepository.findById(studentId);
        if (tmpOptionalStudent.isEmpty()) {
            throw new StudentNotFoundException();
        } else {
            tmpOptionalStudent.get().getGrades().add(grade);
            studentRepository.save(tmpOptionalStudent.get());
        }
    }

    public List<Grade> getAllGradesByStudent(Integer studentId) throws StudentNotFoundException {
        Optional<Student> tmpOptionalStudent = studentRepository.findById(studentId);
        if (tmpOptionalStudent.isEmpty()) {
            throw new StudentNotFoundException();
        } else {
            Student tmpStudent = tmpOptionalStudent.get();
            return tmpStudent.getGrades();
        }
    }

    public List<Student> getAllStudentsGradeGreaterThanEight() {
        return studentRepository.findAll().stream().filter((Student student) -> {
            try {
                return student.getAnnualAverageGrade() >= 8;
            } catch (NoGradesException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    public Student getHighestAverageGradeStudent() throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findAll().stream().max(Comparator.comparingDouble(x-> {
            try {
                return x.getAnnualAverageGrade();
            } catch (NoGradesException e) {
                throw new RuntimeException(e);
            }
        }));
        if(optionalStudent.isEmpty())
            throw new StudentNotFoundException();
        else
            return optionalStudent.get();
    }
}















