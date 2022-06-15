package com.example.listingapp.repository;

import com.example.listingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {



    Optional<User> findUserByEmail(String email);

    @Query(value = "SELECT u.name " +
            "FROM User u  " +
            "JOIN Listing l ON l.user_id = u.id " +
            "join category c on l.category_id=c.id" +
            " where l.price >?1 and c.name='Auto'", nativeQuery = true)
    List<String> findAllUsers(Integer price);

}
