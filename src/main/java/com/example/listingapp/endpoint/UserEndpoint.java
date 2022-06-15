package com.example.listingapp.endpoint;


import com.example.listingapp.dto.UserListenDAO;
import com.example.listingapp.model.User;
import com.example.listingapp.model.UserListen;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    @Autowired
    UserListenDAO userListenDAO;

    @Autowired
    JdbcTemplate jdbcTemplate;

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

//________________________________________________________

//    @GetMapping("/usersPrice/")
//    public List<String> findAllUsersbyPrice(@RequestParam("price") int price ) {
//        System.out.println("Jannnnnnnn");
//
//        System.out.println("Jannnnnnnn");
//        return userService.findAllUsers(price);
//    }

//    @GetMapping("/usersPrice/")
//    public List<User> findAllUsersbyPrice(@RequestParam("price") int price ) {
//        System.out.println("Jannnnnnnn");
//       return jdbcTemplate.query("SELECT * FROM USER", new BeanPropertyRowMapper(User.class));
//    }

    @GetMapping("/usersPrice/")
    public List<UserListen> findAllUsersbyPrice(@RequestParam("price") int price ) {
        System.out.println("Jannnnnnnn");
        return  userListenDAO.allUserListen(price);


    }



}
