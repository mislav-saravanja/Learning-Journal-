package com.example.learningJournal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private ExampleService exampleService;

    public static int calc(int a,int b){
        return a+b;
    }


    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        String x = "hans";
        int y = calc(4,50);
        System.out.println(y);

       List<Greeting> greetings = exampleService.getAllUsers();

        model.addAttribute("greetings", greetings);
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        //Call service to create greeting or use in database
        return "result";
    }

}

