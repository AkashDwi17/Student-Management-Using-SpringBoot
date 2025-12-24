package SpringBootFirstProject.example.AkashSpringBoot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private Long id;
    private String name;
    private  String email;
}


// ❌ password intentionally removed

//Why no password?
// ✔ Password should never be sent in API response