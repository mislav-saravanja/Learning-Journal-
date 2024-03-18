package com.example.learningJournal.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    @NotEmpty(message = "First Name should not be empty")
    private String firstName;
    @NotEmpty(message = "Last Name should not be empty")
    private String lastName;

}
