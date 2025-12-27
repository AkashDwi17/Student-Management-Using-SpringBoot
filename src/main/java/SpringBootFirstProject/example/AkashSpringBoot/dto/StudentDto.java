package SpringBootFirstProject.example.AkashSpringBoot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {

    private Long studentId;
    private String name;
    private String course;
    private String email;
    private Double marks;
}
