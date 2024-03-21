package com.example.learningJournal.Repo;

import com.example.learningJournal.Models.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

    List<Classes> findByName (String className);
    Classes findById(long id);
    @Query("SELECT c FROM Classes c WHERE c.name LIKE CONCAT('%', :query, '%') OR c.description LIKE CONCAT('%', :query, '%')")
    List<Classes> searchClasses(String query);
}