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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @OneToMany
    List<Grade> grades = new ArrayList<Grade>();

    @ManyToOne
    Specialty specialty;

    public Integer getAnnualAverageGrade() throws NoGradesException {
        if(grades.isEmpty()) {
            throw new NoGradesException();
        } else {
            Integer averageGrade = 0;
            for (Grade grade: grades) {
                averageGrade += grade.getGrade();
            }
            return averageGrade/grades.size();
        }
    }
}
