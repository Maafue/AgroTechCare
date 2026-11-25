package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.client.Client;
import by.morozmaksim.AgroTechCare.client.ClientRepository;
import by.morozmaksim.AgroTechCare.client.ClientType;
import by.morozmaksim.AgroTechCare.config.TestConfig;
import by.morozmaksim.AgroTechCare.contract.Contract;
import by.morozmaksim.AgroTechCare.contract.ContractRepository;
import by.morozmaksim.AgroTechCare.contract.ContractType;
import by.morozmaksim.AgroTechCare.machine.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@Import(TestConfig.class)
public class ContractRepositoryTest {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private MachineModelRepository machineModelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldSaveContractWithTwoMachines(){

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
        Machine machine2 = new Machine(
                machineModel,
                client,
                "serial number 2"
        );
        Set<Machine> machineSet = Set.of(machine, machine2);
        machineRepository.saveAll(machineSet);

        Contract contract = new Contract(
                client,
                "number",
                ContractType.SALE);
        contract.addMachine(machine);
        contract.addMachine(machine2);
        Contract savedContract = contractRepository.saveAndFlush(contract);
        entityManager.clear();
        Contract findContract = contractRepository.findById(savedContract.getId()).orElseThrow();
        assertThat(findContract.getMachines().equals(machineSet)).isTrue();
    }

    @Test
    void shouldSaveMachineInTwoContracts(){

        Brand brand = new Brand("brand");
        brandRepository.saveAndFlush(brand);

        MachineModel machineModel = new MachineModel("machine model", brand);
        machineModelRepository.saveAndFlush(machineModel);

        Client client = new Client(ClientType.INDIVIDUAL, "client", "999");
        clientRepository.saveAndFlush(client);

        Machine machine = new Machine(
                machineModel,
                client,
                "serial number"
        );
        machineRepository.save(machine);
        Contract contract = new Contract(
                client,
                "number",
                ContractType.SALE);
        contract.addMachine(machine);
        contractRepository.saveAndFlush(contract);

        Contract contract2 = new Contract(
                client,
                "number2",
                ContractType.SALE);
        contract2.addMachine(machine);
        contractRepository.saveAndFlush(contract2);

        entityManager.clear();

        Contract savedContract = contractRepository.findById(contract.getId()).orElseThrow();
        Contract savedContract2 = contractRepository.findById(contract2.getId()).orElseThrow();
        assertThat(savedContract.getMachines().contains(machine)).isTrue();
        assertThat(savedContract2.getMachines().contains(machine)).isTrue();

    }

    @Test
    void shouldNotSaveContractWithEndDateSmallerSignedDate(){
        Client client = new Client(ClientType.INDIVIDUAL, "client", "999");
        clientRepository.saveAndFlush(client);

        Contract contract = new Contract(
                client,
                "number",
                ContractType.SALE);

        LocalDate localDate = LocalDate.now();
        contract.setSignedDate(localDate.plusDays(1L));
        contract.setEndDate(localDate);
        assertThatThrownBy(()->{
            contractRepository.saveAndFlush(contract);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("chk_contracts_signed_date_end_date");
    }
}
