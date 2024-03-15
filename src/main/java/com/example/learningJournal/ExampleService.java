package com.example.learningJournal;

import org.h2.engine.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    public List<Greeting> getAllUsers() {
        Greeting greeting = new Greeting();
        greeting.setContent("yusuf");
        Greeting greeting2 = new Greeting();
        greeting2.setContent("mehmet");
        Greeting greeting3 = new Greeting();
        greeting3.setContent("ali");
        Greeting greeting4 = new Greeting();
        greeting4.setContent("veli");

        return List.of(greeting, greeting2, greeting3, greeting4);


    }



    public void handleAddUser(Greeting dto){
        //Create User Enttity from String / DTO
        //Call Repository to create user in DB
    }

    public List<Greeting> handleGetAllGreetings(){
        //load all users from repository
        //transfer UserEntity to Greeting DTO
        return null; //change this
    }
}
