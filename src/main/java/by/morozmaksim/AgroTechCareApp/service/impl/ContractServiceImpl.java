package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.exception.ResourceNotFoundException;
import by.morozmaksim.AgroTechCareApp.repository.ContractRepository;
import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.service.ContractService;
import by.morozmaksim.AgroTechCareApp.service.UserService;
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
    public Contract update(Contract contract, Long userid) {
        User user = userService.findById(userid);
        contract.setUser(user);
        return contractRepository.save(contract);
    }

    @Override
    public void delete(Long id) {
        Contract contract = findById(id);
        contractRepository.delete(contract);
    }
}
