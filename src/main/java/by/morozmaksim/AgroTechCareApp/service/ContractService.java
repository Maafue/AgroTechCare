package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;
import java.util.List;

public interface ContractService {

    Contract findById(Long id);
    List<Contract> findAll();
    Contract create(Contract contract, Long userId);
    Contract update(Contract contract, Long userId);
    void delete(Long id);

}
