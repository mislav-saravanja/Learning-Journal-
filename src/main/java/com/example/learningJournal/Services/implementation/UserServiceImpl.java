package com.example.learningJournal.Services.implementation;

import com.example.learningJournal.Dto.UserDto;
import com.example.learningJournal.Models.User;
import com.example.learningJournal.Repo.UserRepository;
import com.example.learningJournal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = mapToUser(userDto);
        return userRepository.save(user);
    }

    @Override
    public UserDto findByUserId(long userId) {
        User user = userRepository.findById(userId);
        return mapToUserDto(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> searchUsers(String query) {
        List<User> users = userRepository.searchUsers(query);
        return users.stream().map(user -> mapToUserDto(user)).collect(Collectors.toList());
    }

    private User mapToUser(UserDto user) {
        User userDto = User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        return userDto;
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        return userDto;
    }
}
