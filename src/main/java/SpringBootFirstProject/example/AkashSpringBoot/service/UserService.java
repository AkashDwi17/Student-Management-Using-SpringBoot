package SpringBootFirstProject.example.AkashSpringBoot.service;

import SpringBootFirstProject.example.AkashSpringBoot.entity.User;
import SpringBootFirstProject.example.AkashSpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    // 1 Register
    public User register (User user) {
        return userRepository.save(user);
    }

    // 2 Login
    public User login(String email, String password){
        return userRepository.findByEmail(email).filter(u -> u.getPassword().equals(password)).orElseThrow(() -> new RuntimeException("Invalid Credentials"));
    }

    // 3 Get all users
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    // 4 Get User By Id
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 5 Update User
    public User updateUser (Long id, User newUser){
        User user = getUserById(id);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        return userRepository.save(user);
    }

    // 6 Delete User
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}



//Flow clarity:
//
//Controller → calls Service
//
//Service → calls Repository
//
//Repository → talks to DB