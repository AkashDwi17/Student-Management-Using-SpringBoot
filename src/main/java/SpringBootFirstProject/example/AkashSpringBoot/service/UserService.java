package SpringBootFirstProject.example.AkashSpringBoot.service;

import SpringBootFirstProject.example.AkashSpringBoot.dto.UserDto;
import SpringBootFirstProject.example.AkashSpringBoot.entity.User;
import SpringBootFirstProject.example.AkashSpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 🔁 Entity → DTO conversion
    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    // 1️⃣ Register
    public UserDto register(User user) {
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    // 2️⃣ Login
    public UserDto login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid Credentials"));

        return convertToDto(user);
    }

    // 3️⃣ Get all users
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 4️⃣ Get user by id
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return convertToDto(user);
    }

    // 5️⃣ Update user
    public UserDto updateUser(Long id, User newUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());

        return convertToDto(userRepository.save(user));
    }

    // 6️⃣ Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
