package SpringBootFirstProject.example.AkashSpringBoot.repository;


import SpringBootFirstProject.example.AkashSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository gives CRUD automatically

public interface UserRepository extends JpaRepository <User, Long>{

    // Used in Login
    Optional<User> findByEmail (String email);
}





//public class UserRepository {
//}



