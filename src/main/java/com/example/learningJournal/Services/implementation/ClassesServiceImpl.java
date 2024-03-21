package com.example.learningJournal.Services.implementation;

import com.example.learningJournal.Dto.ClassesDto;
import com.example.learningJournal.Models.Classes;
import com.example.learningJournal.Repo.ClassesRepository;
import com.example.learningJournal.Services.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassesServiceImpl implements ClassesService {

    final ClassesRepository classesRepository;

    @Autowired
    public ClassesServiceImpl(ClassesRepository classesRepository){
        this.classesRepository = classesRepository;
    }

    @Override

    public List<ClassesDto> findAllClasses(){
        List<Classes> classeses = classesRepository.findAll();
        return classeses.stream().map((classes)-> mapToClassesDto(classes)).collect(Collectors.toList());


    }

    private ClassesDto mapToClassesDto(Classes classes) {
        ClassesDto classesDto = ClassesDto.builder()
                .id(classes.getId())
                .name(classes.getName())
                .description(classes.getDescription())
               // .username(classes.getUsername())
                .build();
        return classesDto;
    }
    @Override
    public Classes saveClasses(ClassesDto classesDto){
        Classes classes = mapToClasses(classesDto);
        return classesRepository.save(classes);
    }
    private Classes mapToClasses(ClassesDto classes) {
        Classes classesDto = Classes.builder()
                .id(classes.getId())
                .name(classes.getName())
                .description(classes.getDescription())
                .build();
        return classesDto;
    }
    @Override

    public ClassesDto findByClassesId(long classesId) {
        Classes classes = classesRepository.findById(classesId);
        return mapToClassesDto(classes);
    }
    @Override
    public void updateClasses(ClassesDto classesDto) {
        Classes classes = mapToClasses(classesDto);
        classesRepository.save(classes);
    }
    @Override
    public void deleteClasses(Long classesId) {
        classesRepository.deleteById(classesId);
    }
    @Override
    public List <ClassesDto> searchClasses(String query){
        List<Classes> classeses = classesRepository.searchClasses(query);
        return classeses.stream().map(classes -> mapToClassesDto(classes)).collect(Collectors.toList());
    }






}

