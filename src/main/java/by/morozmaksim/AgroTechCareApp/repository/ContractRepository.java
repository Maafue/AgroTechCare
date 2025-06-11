package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;

import java.util.List;

public interface ContractRepository {
    Contract findById(Long id);
    List<Contract> findAll();
    Contract create(Contract contract);
    Contract update(Contract contract);
    void delete(Contract contract);
}
