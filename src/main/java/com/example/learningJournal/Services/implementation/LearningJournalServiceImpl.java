package com.example.learningJournal.Services.implementation;

import com.example.learningJournal.Dto.LearningJournalDto;
import com.example.learningJournal.Models.LearningJournal;
import com.example.learningJournal.Repo.LearningJournalRepository;
import com.example.learningJournal.Services.LearningJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LearningJournalServiceImpl implements LearningJournalService {

    LearningJournalRepository learningJournalRepository;
    @Autowired
    public LearningJournalServiceImpl(LearningJournalRepository learningJournalRepository) {
        this.learningJournalRepository = learningJournalRepository;
    }

    @Override
    public List<LearningJournalDto> findAllLearningJournals() {
        List<LearningJournal> learningJournals = learningJournalRepository.findAll();
        return learningJournals.stream().map((learningJournal) -> mapToLearningJournalDto(learningJournal)).collect(Collectors.toList());

    }

    @Override
    public void saveJournal(LearningJournalDto learningJournalDto) {
        LearningJournal learningJournal = mapToLearningJournal(learningJournalDto);
        learningJournalRepository.save(learningJournal);
    }

    @Override
    public void deleteJournal(long learningJournalId) {
        learningJournalRepository.deleteById(learningJournalId);
    }

    @Override
    public LearningJournalDto findByJournalId(long learningJournalId) {
        LearningJournal learningJournal = learningJournalRepository.findById(learningJournalId).get();
        return mapToLearningJournalDto(learningJournal);
    }

    private LearningJournal mapToLearningJournal(LearningJournalDto learningJournalDto) {
        LearningJournal learningJournal = LearningJournal.builder()
                .id(learningJournalDto.getId())
                .title(learningJournalDto.getTitle())
                .content(learningJournalDto.getContent())
                .createdOn(learningJournalDto.getCreatedOn())
                .updatedOn(learningJournalDto.getUpdatedOn())
                .build();
        return learningJournal;
    }


    private LearningJournalDto mapToLearningJournalDto(LearningJournal learningJournal){
        LearningJournalDto learningJournalDto = LearningJournalDto.builder()
                .id(learningJournal.getId())
                .title(learningJournal.getTitle())
                .content(learningJournal.getContent())
                .createdOn(learningJournal.getCreatedOn())
                .updatedOn(learningJournal.getUpdatedOn())
                .build();
        return learningJournalDto;

    }
}
