package SpringBootFirstProject.example.AkashSpringBoot.controller;

import SpringBootFirstProject.example.AkashSpringBoot.dto.UserDto;
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

    // 1️⃣ Register
    @PostMapping("/register")
    public UserDto register(@RequestBody User user) {
        return userService.register(user);
    }

    // 2️⃣ Login
    @PostMapping("/login")
    public UserDto login(@RequestBody Map<String, String> data) {
        return userService.login(
                data.get("email"),
                data.get("password")
        );
    }

    // 3️⃣ Get All
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAllUsers();
    }

    // 4️⃣ Get By Id
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 5️⃣ Update
    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id,
                          @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // 6️⃣ Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }
}



//-----------------------------------------------------------------------------------------------
//
//        return convertToDto(userRepository.save(user));
//
//        return convertToDto(user);
//
//does it means when we have to return from dto package what is its actual meaning
//
//Excellent question 👌
//This is one of the most important concepts in DTO usage.
//        Let’s clear it slowly, practically, and with meaning — not just syntax.
//
//🔑 SHORT ANSWER (1 LINE)
//
//return convertToDto(...) means “before sending data outside the service layer, convert the internal Entity (User) into a safe DTO (UserDto).”
//
//Now let’s go deep but simple 👇
//
//        🧱 FIRST: WHAT EACH THING REPRESENTS
//1️⃣ User (Entity)
//User user
//
//
//Represents database row
//
//Contains password
//
//Used only inside backend
//
//Never safe to send directly to client
//
//2️⃣ UserDto (DTO)
//UserDto
//
//
//Represents API response
//
//Contains only required fields
//
//Safe to send to client
//
//        No password, no DB internals
//
//🔁 WHAT convertToDto() ACTUALLY MEANS
//private UserDto convertToDto(User user) {
//    return UserDto.builder()
//            .id(user.getId())
//            .name(user.getName())
//            .email(user.getEmail())
//            .build();
//}
//
//Meaning in plain English:
//
//        “Take a full database object and create a clean, safe copy for the outside world.”
//
