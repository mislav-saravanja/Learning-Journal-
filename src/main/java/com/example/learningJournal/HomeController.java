package com.example.learningJournal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/classes")
    public String classes() {
        return "classes";
    }

    @GetMapping("/journal")
    public String journal() {
        return "journal";
    }


}



