package com.example.listingapp.endpoint;


import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> allUsers(){
        return userService.userAll();
    }

    @GetMapping("/users/{id}")
    public User  getuserById(@PathVariable ("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
          return userService.addUser(user);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity <User> updateUserById(@PathVariable ("id") int id, @RequestBody User user){
    return  userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    private ResponseEntity<User> deleteById(@PathVariable ("id") int id){
        return userService.deleteUser(id);
    }




}
