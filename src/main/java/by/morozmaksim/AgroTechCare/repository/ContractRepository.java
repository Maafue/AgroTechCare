package by.morozmaksim.AgroTechCare.repository;

import by.morozmaksim.AgroTechCare.domain.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
