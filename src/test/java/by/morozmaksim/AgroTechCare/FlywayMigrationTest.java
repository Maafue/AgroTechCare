package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestConfig.class)
class FlywayMigrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void shouldApplyV1Migration() {
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
        assertThat(migrationApplied).isTrue();
    }
}
