package com.example.practicebackend;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserResponseDTO userResponseDTO;

    public UserService(UserRepository userRepository, UserResponseDTO userResponseDTO) {
        this.userRepository = userRepository;
        this.userResponseDTO = userResponseDTO;
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUserById(long id) {

        userRepository.deleteById(id);
    }
    public User updateUser(Long id,  User updateUser){
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        user.setName(updateUser.getName());
        user.setAge(updateUser.getAge());
        user.setEmail(updateUser.getEmail());
       return  userRepository.save(user);

    }
    public UserResponseDTO convertToDTO(User user){
          return new UserResponseDTO(
                  user.getName(),user.getEmail()
          );
    }
}
