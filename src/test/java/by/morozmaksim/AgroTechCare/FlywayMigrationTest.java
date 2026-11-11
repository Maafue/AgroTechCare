package by.morozmaksim.AgroTechCare;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class FlywayMigrationTest {

    @Container
    @ServiceConnection
    private static PostgreSQLContainer<?> postgreSQLContainer
            = new PostgreSQLContainer<>("postgres:17");
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testMigrationWork() {
        String sql = """
                SELECT EXISTS(
                    SELECT
                        1
                    FROM
                        flyway_schema_history fsh
                    WHERE
                        fsh.version = ?
                        AND fsh.success = ?)
                """;
        Boolean migrationApplied = jdbcTemplate.queryForObject(sql, Boolean.class, "1", true);
        Assertions.assertThat(migrationApplied).isTrue();
    }
}
