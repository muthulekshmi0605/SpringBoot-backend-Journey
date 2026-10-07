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
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User updateUser){
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        user.setName(updateUser.getName());
        user.setAge(updateUser.getAge());
        user.setEmail(updateUser.getEmail());
        return userRepository.save(user);
    }
}
