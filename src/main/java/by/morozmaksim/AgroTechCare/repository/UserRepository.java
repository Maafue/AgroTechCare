package by.morozmaksim.AgroTechCare.repository;

import by.morozmaksim.AgroTechCare.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
