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

        userService.deleteUserById(id);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User updateUser){
        return userService.updateUser(id,updateUser);

    }
}
