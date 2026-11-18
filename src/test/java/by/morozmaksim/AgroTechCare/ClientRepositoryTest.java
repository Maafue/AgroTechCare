package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.client.Client;
import by.morozmaksim.AgroTechCare.client.ClientRepository;
import by.morozmaksim.AgroTechCare.client.ClientType;
import by.morozmaksim.AgroTechCare.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DataJpaTest
@Import(TestConfig.class)
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void shouldSaveClientWithUNP(){
        Client client = new Client(ClientType.LEGAL, "Legal_Client", "77777");
        client.setUnp("unp");
        Client saved = clientRepository.saveAndFlush(client);
        assertThat(saved.getUnp()).isEqualTo("unp");
    }
    @Test
    void shouldSaveClientWithoutUNP(){
        Client client = new Client(ClientType.INDIVIDUAL, "Individual_Client", "77777");
        Client saved = clientRepository.saveAndFlush(client);
        assertThat(saved.getUnp()).isEqualTo(null);
    }
    @Test
    void shouldNotSaveClientWithoutUNP(){
        Client client = new Client(ClientType.LEGAL, "Legal_Client", "77777");
        assertThatThrownBy(() -> {
            clientRepository.saveAndFlush(client);
        })
                // По идее, достаточно - hasMessageContaining("chk_clients_type_unp")
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("chk_clients_type_unp");
    }

}
