package com.example.learningJournal.Services;

import com.example.learningJournal.Dto.UserDto;
import com.example.learningJournal.Models.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    User saveUser(UserDto userDto);

    UserDto findByUserId(long userId);

    void updateUser(UserDto user);

    void deleteUser(Long userId);

    List<UserDto> searchUsers(String query);
}
