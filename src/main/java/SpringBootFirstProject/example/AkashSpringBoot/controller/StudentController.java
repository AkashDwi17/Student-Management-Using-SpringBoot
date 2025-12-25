package SpringBootFirstProject.example.AkashSpringBoot.controller;

import SpringBootFirstProject.example.AkashSpringBoot.dto.StudentDto;
import SpringBootFirstProject.example.AkashSpringBoot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    // 1️⃣ Register
    @PostMapping
    public StudentDto register(@RequestBody StudentDto dto) {
        return service.register(dto);
    }

    // 2️⃣ Get All
    @GetMapping
    public List<StudentDto> getAll() {
        return service.getAll();
    }

    // 3️⃣ Get By ID
    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // 4️⃣ Update
    @PutMapping("/{id}")
    public StudentDto update(@PathVariable Long id,
                             @RequestBody StudentDto dto) {
        return service.update(id, dto);
    }

    // 5️⃣ Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Student deleted successfully";
    }
}
