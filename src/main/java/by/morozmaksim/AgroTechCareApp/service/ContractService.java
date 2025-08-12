package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.entity.contract.Contract;
import by.morozmaksim.AgroTechCareApp.web.dto.ContractDto;

import java.util.List;

public interface ContractService {

    Contract findById(Long id);

    List<Contract> findAll();

    Contract create(Contract contract, Long userId);

    Contract update(ContractDto contractDto);

    void delete(Long id);

}
