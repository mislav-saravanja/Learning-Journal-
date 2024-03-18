package com.example.learningJournal.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "user_entity")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;






}
