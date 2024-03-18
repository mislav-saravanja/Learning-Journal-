package com.example.learningJournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningJournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningJournalApplication.class, args);
	}

}
