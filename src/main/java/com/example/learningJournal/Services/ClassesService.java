package com.example.learningJournal.Services;

import com.example.learningJournal.Dto.ClassesDto;
import com.example.learningJournal.Models.Classes;

import java.util.List;

public interface ClassesService {
    List<ClassesDto> findAllClasses();

    Classes saveClasses(ClassesDto classesDto);

    ClassesDto findByClassesId(long classesId);

    void updateClasses(ClassesDto classesDto);

    void deleteClasses(Long classesId);

    List <ClassesDto> searchClasses(String query);
}