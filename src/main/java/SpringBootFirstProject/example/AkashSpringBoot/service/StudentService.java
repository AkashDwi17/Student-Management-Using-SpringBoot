package SpringBootFirstProject.example.AkashSpringBoot.service;

import SpringBootFirstProject.example.AkashSpringBoot.dto.StudentDto;
import SpringBootFirstProject.example.AkashSpringBoot.entity.Student;
import SpringBootFirstProject.example.AkashSpringBoot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    // DTO → Entity
    private Student toEntity(StudentDto dto) {
        return Student.builder()
                .studentId(dto.getStudentId())
                .name(dto.getName())
                .course(dto.getCourse())
                .email(dto.getEmail())
                .marks(dto.getMarks())
                .build();
    }

    // Entity → DTO
    private StudentDto toDto(Student student) {
        return StudentDto.builder()
                .studentId(student.getStudentId())
                .name(student.getName())
                .course(student.getCourse())
                .email(student.getEmail())
                .marks(student.getMarks())
                .build();
    }

    // 1️⃣ Register Student
    public StudentDto register(StudentDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    // 2️⃣ Get All Students
    public List<StudentDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // 3️⃣ Get Student By ID
    public StudentDto getById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return toDto(student);
    }

    // 4️⃣ Update Student
    public StudentDto update(Long id, StudentDto dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setCourse(dto.getCourse());
        student.setEmail(dto.getEmail());
        student.setMarks(dto.getMarks());

        return toDto(repository.save(student));
    }

    // 5️⃣ Delete Student
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
