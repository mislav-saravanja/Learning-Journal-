package com.example.learningJournal.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ClassesDto {

    private long id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Description should not be empty")
    private String description;

}

