package com.example.learningJournal.Repo;

import com.example.learningJournal.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastName (String lastName);
    User findById(long id);

    @Query("SELECT c FROM User c WHERE c.firstName LIKE CONCAT('%', :query, '%') OR c.lastName LIKE CONCAT('%', :query, '%')")
    List<User> searchUsers(String query);
}
