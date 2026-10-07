package com.example.practicebackend;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    private List<User> users = new ArrayList<>();
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
       return userService.createUser(user);

    }
    @GetMapping("/users")
    public List<User> getUsers(){

        return userService.getAllUser();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){

        return userService.getUserById(id);
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
