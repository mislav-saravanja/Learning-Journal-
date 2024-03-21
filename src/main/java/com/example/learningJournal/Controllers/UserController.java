package com.example.learningJournal.Controllers;


import com.example.learningJournal.Dto.UserDto;
import com.example.learningJournal.Models.User;
import com.example.learningJournal.Services.UserService;
import jakarta.validation.Valid;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/users")
    public String listUsers (Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users-list";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "users-create";
    }



    @GetMapping("/users/{userId}")
    public String userDetail(@PathVariable("userID") long userId, Model model){
        UserDto userDto = userService.findByUserId(userId);
        model.addAttribute("user", userDto);
        return "user-detail";
    }

    @GetMapping("/users/search")
    public String searchUser(@RequestParam(value = "query") String query, Model model){
        List<UserDto> users = userService.searchUsers(query);
        model.addAttribute("users", users);
        return "users-list";
    }

    @PostMapping("/users/new")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("user", userDto);
            return "users-create";
        }
        userService.saveUser(userDto);
        return "redirect:/users";
    }

    @GetMapping("/users/{userId}/edit")
    public String editUserForm(@PathVariable("userId") long userId, Model model){
        UserDto user = userService.findByUserId(userId);
        model.addAttribute("user", user);
        return "users-edit";
    }

    @PostMapping("/users/{userId}/edit")
    public String updateClub(@PathVariable("userId") Long userId,
                             @Valid @ModelAttribute("user") UserDto user,
                             BindingResult result){
        if (result.hasErrors()){
            return "users-edit";
        }
        user.setId(userId);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping ("/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") long userId){
        userService.deleteUser(userId);
        return "redirect:/users";
    }

}
