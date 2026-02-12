package by.morozmaksim.AgroTechCare.service;

import by.morozmaksim.AgroTechCare.domain.entity.contract.Contract;
import by.morozmaksim.AgroTechCare.web.dto.ContractDto;

import java.util.List;

public interface ContractService {

    Contract findById(Long id);

    List<Contract> findAll();

    Contract create(Contract contract, Long userId);

    Contract update(ContractDto contractDto, Long id);

    void delete(Long id);

}
