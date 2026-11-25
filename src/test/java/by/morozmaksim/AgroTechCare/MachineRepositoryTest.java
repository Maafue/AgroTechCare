package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.client.Client;
import by.morozmaksim.AgroTechCare.client.ClientRepository;
import by.morozmaksim.AgroTechCare.client.ClientType;
import by.morozmaksim.AgroTechCare.config.TestConfig;
import by.morozmaksim.AgroTechCare.machine.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DataJpaTest
@Import(TestConfig.class)
public class MachineRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private MachineModelRepository machineModelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void shouldNotSaveMachineWithDuplicateSerialNumber(){

        Client client = new Client(ClientType.INDIVIDUAL, "client", "999");
        clientRepository.saveAndFlush(client);

        Brand brand = new Brand("brand");
        brandRepository.saveAndFlush(brand);

        MachineModel machineModel = new MachineModel("machine model", brand);
        machineModelRepository.saveAndFlush(machineModel);

        Machine machine = new Machine(
                machineModel,
                client,
                "serial number"
        );
        machineRepository.saveAndFlush(machine);

        Machine machine2 = new Machine(
                machineModel,
                client,
                "serial number"
        );
        assertThatThrownBy(()->{
            machineRepository.saveAndFlush(machine2);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("machines_serial_number_duplicate");
    }
}

