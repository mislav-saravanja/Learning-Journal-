package com.example.learningJournal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {


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
