package com.example.practicebackend;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private List<User> users = new ArrayList<>();
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
       userRepository.save(user);
        return user;
    }
    @GetMapping("/users")
    public List<User> getUsers(){

        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){

        return userRepository.findById(id) .orElse(null);
    }
}
