package com.example.listingapp.service;

import com.example.listingapp.model.User;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface UserService {
    List<String> findAllUsers(Integer price);

    List<User> userAll();

    User getUserById(int id);

    User addUser(User user);

    ResponseEntity<User> updateUser(int id,User user);

    ResponseEntity<User> deleteUser(int id);
}
