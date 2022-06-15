package com.example.listingapp.service.imp;

import com.example.listingapp.model.User;
import com.example.listingapp.repository.UserRepository;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<String> findAllUsers(Integer price) {
        System.out.println("UserServiceIml");
        return userRepository.findAllUsers(price);

    }

    @Override
    public List<User> userAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> updateUser(int id, User user) {
        Optional <User> userById = userRepository.findById(id);
        if (userById.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        User userDB = userById.get();
        userDB.setName(user.getName());
        userDB.setSurname(user.getSurname());
        userDB.setEmail(user.getEmail());
        userDB.setPassword(user.getPassword());
        userDB.setRole(user.getRole());
        return ResponseEntity.ok().body(userRepository.save(userDB));
    }

    @Override
    public ResponseEntity<User> deleteUser(int id) {
        Optional<User> delUserById = userRepository.findById(id);
        if (delUserById.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
