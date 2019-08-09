package ir.arcademy.notes.modules.user.repository;

import ir.arcademy.notes.modules.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String name) ;
}
