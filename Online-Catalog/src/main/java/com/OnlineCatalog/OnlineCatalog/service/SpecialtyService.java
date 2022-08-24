package com.OnlineCatalog.OnlineCatalog.service;

import com.OnlineCatalog.OnlineCatalog.exception.NoGradesException;
import com.OnlineCatalog.OnlineCatalog.exception.SpecialtyNotFoundException;
import com.OnlineCatalog.OnlineCatalog.model.Specialty;
import com.OnlineCatalog.OnlineCatalog.model.Student;
import com.OnlineCatalog.OnlineCatalog.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public List<Student> getAllStudentBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException {
        Optional<Specialty> tmpOptionalSpecialty = specialtyRepository.findById(specialtyId);
        if (tmpOptionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        } else {
            return tmpOptionalSpecialty.get().getStudents();
        }
    }

    public Specialty getSpecialtyWithMostStudents() throws SpecialtyNotFoundException {
        Optional<Specialty> optionalSpecialty = specialtyRepository.findAll().stream()
                .max(Comparator.comparing(x -> x.getStudents().size()));
        if (optionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        }
        else
            return optionalSpecialty.get();
    }

    public Double getAverageGradeOfASpecialty(Integer specialtyId) throws SpecialtyNotFoundException, NoGradesException {
        Optional<Specialty> optionalSpecialty = specialtyRepository.findById(specialtyId);
        if (optionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        }
        else
            return optionalSpecialty.get().getAverageGradeOfASpecialty();
    }

    public Student getHighestAverageGradeStudentBySpecialty(Integer specialtyId) throws NoGradesException, SpecialtyNotFoundException {
        Optional<Specialty> optionalSpecialty = specialtyRepository.findById(specialtyId);
        if(optionalSpecialty.isEmpty())
            throw new SpecialtyNotFoundException();
        else
            return optionalSpecialty.get().getHighestAverageGradeStudentOfASpecialty();

    }
}
