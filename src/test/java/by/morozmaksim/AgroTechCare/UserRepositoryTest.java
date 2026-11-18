package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.config.TestConfig;
import by.morozmaksim.AgroTechCare.user.Role;
import by.morozmaksim.AgroTechCare.user.User;
import by.morozmaksim.AgroTechCare.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@Import(TestConfig.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldNotSaveUserClientWithoutClientId() {
        User user = new User(
                "username",
                "pwd",
                "lastname",
                "firstname",
                Role.CLIENT,
                true);

        assertThatThrownBy(() -> {
            userRepository.saveAndFlush(user);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("chk_users_role_client_id");
    }

    @Test
    void shouldNotSaveUserWithDuplicateUsername() {
        User user = new User(
                "username",
                "pwd",
                "lastname",
                "firstname",
                Role.MANAGER,
                true);

        userRepository.saveAndFlush(user);

        User duplicate = new User(
                "username",
                "pwd",
                "lastname",
                "firstname",
                Role.MANAGER,
                true);

        assertThatThrownBy(() -> {
            userRepository.saveAndFlush(duplicate);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("users_username_key");
    }
}