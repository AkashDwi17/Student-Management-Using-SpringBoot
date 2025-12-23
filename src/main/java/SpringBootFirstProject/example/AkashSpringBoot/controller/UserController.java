package SpringBootFirstProject.example.AkashSpringBoot.controller;

import SpringBootFirstProject.example.AkashSpringBoot.entity.User;
import SpringBootFirstProject.example.AkashSpringBoot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    // 1 Register
    @PostMapping("/register")
    public User register (@RequestBody User user){
        return userService.register(user);
    }

    // 2 Login
    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> data){
        return userService.login(
                data.get("email"),
                data.get("password")
        );
    }

    // 3 Get All
    @GetMapping
    public List<User> getAll(){
        return userService.getAllUser();
    }

    // 4 Get By Id
    @GetMapping("/id/{id}")
    public User getById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    // 5 Update
    @PutMapping("/id/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    // Delete
    @DeleteMapping("/id/{id}")
    public String delete(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Deleted Suscessfully";
    }

}
