package by.morozmaksim.AgroTechCare.service.impl;

import by.morozmaksim.AgroTechCare.domain.entity.contract.Contract;
import by.morozmaksim.AgroTechCare.domain.exception.ResourceNotFoundException;
import by.morozmaksim.AgroTechCare.domain.entity.user.User;
import by.morozmaksim.AgroTechCare.repository.ContractRepository;
import by.morozmaksim.AgroTechCare.service.ContractService;
import by.morozmaksim.AgroTechCare.service.UserService;
import by.morozmaksim.AgroTechCare.web.dto.ContractDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final UserService userService;

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found with id " + id));
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract create(Contract contract, Long userid) {
        User user = userService.findById(userid);
        contract.setUser(user);
        contract.setDate(LocalDateTime.now());
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public Contract update(ContractDto contractDto, Long id) {
        Contract excistingContract = findById(id);
        excistingContract.setPrepayment(contractDto.getPrepayment());
        excistingContract.setDebt(contractDto.getDebt());
        excistingContract.setOverdueDebt(contractDto.getOverdueDebt());

        if (id != null) {
            User user = userService.findById(id);
            excistingContract.setUser(user);
        }

        return contractRepository.save(excistingContract);
    }

    @Override
    public void delete(Long id) {
        Contract contract = findById(id);
        contractRepository.delete(contract);
    }
}
