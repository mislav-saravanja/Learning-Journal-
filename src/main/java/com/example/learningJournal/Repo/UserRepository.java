package com.example.learningJournal.Repo;

import com.example.learningJournal.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByUsername (String username);
    UserEntity findByEmail (String email);
    UserEntity findById(long id);

    UserEntity findByFirstName(String firstName);
    UserEntity findByLastName(String lastName);

    @Query("SELECT c FROM UserEntity c WHERE c.username LIKE CONCAT('%', :query, '%') " +
            "OR c.firstName LIKE CONCAT('%', :query, '%') " +
            "OR c.lastName LIKE CONCAT('%', :query, '%')")
    List<UserEntity> searchUserEntities(String query);

}
