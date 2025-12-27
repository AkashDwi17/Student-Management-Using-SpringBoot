package SpringBootFirstProject.example.AkashSpringBoot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;
    private String course;

    @Column(unique = true)
    private String email;

    private Double marks;
}
