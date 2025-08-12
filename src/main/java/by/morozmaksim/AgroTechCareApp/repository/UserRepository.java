package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
