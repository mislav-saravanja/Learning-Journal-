package com.example.learningJournal.Controllers;


import com.example.learningJournal.Dto.UserDto;
import com.example.learningJournal.Models.UserEntity;
import com.example.learningJournal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    //List Users
    @GetMapping("/users")
    public String listUsers (Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users-list";
    }
    //Create User Form and click save user
    @GetMapping("/users/new")
    public String createUserForm(Model model){
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "users-create";
    }
    @PostMapping("/users/new")
    public String saveUser( @ModelAttribute("user") UserDto userDto){
        userService.saveUser(userDto);
        return "redirect:/users";
    }
    //Edit user GET and POST
    @GetMapping("/users/{userId}/edit")
    public String editUserForm(@PathVariable("userId") long userId, Model model){
        UserDto user = userService.findByUserId(userId);
        model.addAttribute("user", user);
        return "users-edit";
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable("userId") Long userId, @ModelAttribute("user") UserDto user){
        user.setId(userId);
        userService.updateUser(user);
        return "redirect:/users";
    }

    //Delete User POST

    @PostMapping ("/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") long userId){
        userService.deleteUser(userId);
        return "redirect:/users";
    }



    @GetMapping("/users/search")
    public String searchUser(@RequestParam(value = "query") String query, Model model){
        List<UserDto> users = userService.searchUsers(query);
        model.addAttribute("users", users);
        return "users-list";
    }





    @GetMapping("/users/{userId}")
    public String userDetail(@PathVariable("userID") long userId, Model model){
        UserDto userDto = userService.findByUserId(userId);
        model.addAttribute("user", userDto);
        return "user-detail";
    }


}
