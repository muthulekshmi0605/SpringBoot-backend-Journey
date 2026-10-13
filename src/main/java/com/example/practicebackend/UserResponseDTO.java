package com.example.practicebackend;

public class UserResponseDTO {
    private String name;
    private String  email;
    private int age;
    public UserResponseDTO(String name, String email,int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public String getName() {

        return name;
    }
    public String getEmail() {
        return email;

    }
    public int getAge() {
        return age;
    }
}
