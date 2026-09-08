package com.example.practicebackend;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello "+name+" World!";
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "welcome"+name;
    }
    @PostMapping("/hello")
    public String post(){
        return "Data Received";
    }
    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        return user.getName()+user.getAge();
    }
}
