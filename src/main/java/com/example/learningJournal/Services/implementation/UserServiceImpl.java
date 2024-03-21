package com.example.learningJournal.Services.implementation;

import com.example.learningJournal.Dto.UserDto;
import com.example.learningJournal.Models.Role;
import com.example.learningJournal.Models.UserEntity;
import com.example.learningJournal.Repo.RoleRepository;
import com.example.learningJournal.Repo.UserRepository;
import com.example.learningJournal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }




    @Override
    public List<UserDto> findAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public UserDto findByUserId(long userId) {
        UserEntity user = userRepository.findById(userId);
        return mapToUserDto(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        UserEntity user = mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> searchUsers(String query) {
        List<UserEntity> users = userRepository.searchUserEntities(query);
        return users.stream().map(user -> mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public  UserEntity findByFirstName(String firstName){
        return  userRepository.findByFirstName(firstName);
    }

    @Override
    public UserEntity findByLastName(String lastName){
        return userRepository.findByLastName(lastName);
    }

    private UserEntity mapToUser(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
        return userEntity;
    }

    private UserDto mapToUserDto(UserEntity userEntity) {
        UserDto userDto = UserDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .build();
        return userDto;
    }
}
