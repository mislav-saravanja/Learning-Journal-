package com.example.learningJournal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class NavigationController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/journal")
    public String journal() {
        return "home";
    }
    @GetMapping ("/klasses")
    public String klasses(){
        return "klasses";
    }
    @GetMapping ("/users")
    public String users(){
        return "users";
    }
}