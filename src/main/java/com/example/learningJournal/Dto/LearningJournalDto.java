package com.example.learningJournal.Dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LearningJournalDto {
    private Long id;
    private String title;
    private String content;
    private String createdOn;
    private String updatedOn;
}
