package com.example.learningJournal.Repo;

import com.example.learningJournal.Models.LearningJournal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningJournalRepository extends JpaRepository<LearningJournal, Long> {
    List<LearningJournal> findByTitle(String title);

}
