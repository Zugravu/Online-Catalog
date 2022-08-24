package com.OnlineCatalog.OnlineCatalog.model;

import com.OnlineCatalog.OnlineCatalog.exception.NoGradesException;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany
    @NotNull
    List<Student> students = new ArrayList<Student>();

    @OneToMany
    @NotNull
    List<Course> courses = new ArrayList<Course>();

    public Double getAverageGradeOfASpecialty() throws NoGradesException {
        double averageGrade = 0;
        for (Student student : students) averageGrade += student.getAnnualAverageGrade();
        return averageGrade/students.size();
    }

    public Student getHighestAverageGradeStudentOfASpecialty() throws NoGradesException {
        Student highestAverageGradeStudent = new Student();
        highestAverageGradeStudent.getGrades().add(new Grade(0,0));
        for (Student student : students)
            if(student.getAnnualAverageGrade() > highestAverageGradeStudent.getAnnualAverageGrade())
                highestAverageGradeStudent = student;
        return highestAverageGradeStudent;
    }
}
