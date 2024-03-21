package com.example.learningJournal.Services;

import com.example.learningJournal.Dto.UserDto;
import com.example.learningJournal.Models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    void saveUser(UserDto userDto);

    UserDto findByUserId(long userId);

    void updateUser(UserDto user);

    void deleteUser(Long userId);

    List<UserDto> searchUsers(String query);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

    UserEntity findByFirstName(String firstName);
    UserEntity findByLastName(String lastName);
}
