package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.config.TestConfig;
import by.morozmaksim.AgroTechCare.machine.Brand;
import by.morozmaksim.AgroTechCare.machine.BrandRepository;
import by.morozmaksim.AgroTechCare.machine.MachineModel;
import by.morozmaksim.AgroTechCare.machine.MachineModelRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@Import(TestConfig.class)
public class MachineModelRepositoryTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private MachineModelRepository machineModelRepository;
    @Autowired
    private BrandRepository brandRepository;

    @Test
    void shouldSaveMachineModelWithBrandAndReadItBack() {

        var brand = new Brand("brand");
        brandRepository.saveAndFlush(brand);

        var machineModel = new MachineModel("machine model", brand);
        MachineModel savedMachineModel = machineModelRepository.saveAndFlush(machineModel);

        entityManager.clear();
        Optional<MachineModel> found = machineModelRepository.findById(savedMachineModel.getId());
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getName()).isEqualTo("machine model");
        assertThat(found.get().getBrand().getId()).isEqualTo(brand.getId());
    }

    @Test
    void shouldNotSaveModelMachineWithDuplicateNameAndBrand() {
        var brand = new Brand("brand");
        brandRepository.saveAndFlush(brand);

        var machineModel = new MachineModel("machine model", brand);
        machineModelRepository.saveAndFlush(machineModel);

        assertThatThrownBy(() -> {
        var duplicateMachineModel = new MachineModel("machine model", brand);
            machineModelRepository.saveAndFlush(duplicateMachineModel);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("uq_machine_models_brand_id_name");
    }
    @Test
    void shouldSaveModelMachineWithNameAndAnotherBrand(){
        var brand1 = new Brand("brand1");
        var brand2 = new Brand("brand2");

        brandRepository.saveAllAndFlush(List.of(brand1, brand2));
        MachineModel machineModel = new MachineModel("machine model1", brand1);
        MachineModel machineModel2 = new MachineModel("machine model1", brand2);
        machineModelRepository.saveAndFlush(machineModel);
        machineModelRepository.saveAndFlush(machineModel2);
        entityManager.clear();
        assertThat(machineModelRepository.count()).isEqualTo(2);
    }
}
