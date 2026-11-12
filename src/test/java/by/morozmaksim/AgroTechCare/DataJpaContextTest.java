package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestConfig.class)
class DataJpaContextTest {

    @Test
    void contextLoads(){
        assertThat(true).isTrue();
    }
}
