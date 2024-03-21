package com.example.learningJournal.Services;

import com.example.learningJournal.Dto.LearningJournalDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LearningJournalService {
    List<LearningJournalDto> findAllLearningJournals ();

    void saveJournal(LearningJournalDto learningJournalDto);

    void deleteJournal(long learningJournalId);

    LearningJournalDto findByJournalId(long learningJournalId);
}
