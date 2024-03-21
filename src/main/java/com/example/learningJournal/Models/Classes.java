package com.example.learningJournal.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "classes")
//@Entity
public class Classes {
    @Id
    @GeneratedValue
    @Column(name = "class_id")
    private long id;
    @Column (name = "class_name")
    private String name;
    @Column (name = "description")
    private String description;


}
