package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.dao.ContractDao;
import by.morozmaksim.AgroTechCareApp.dao.UserDao;
import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractDao contractDao;
    private final UserDao userDao;

    @Override
    public Contract findById(Long id) {
        return contractDao.findById(id);
    }

    @Override
    public List<Contract> findAll() {
        return contractDao.findAll();
    }

    @Override
    public Contract create(Contract contract, Long userid) {
        User user = userDao.findById(userid);
        contract.setUser(user);
        contract.setDate(LocalDateTime.now());
        contractDao.create(contract);
        return contract;
    }

    @Override
    public Contract update(Contract contract, Long userid) {
        User user = userDao.findById(userid);
        contract.setUser(user);
        return contractDao.update(contract);
    }

    @Override
    public void delete(Long id) {
        Contract contract = findById(id);
        contractDao.delete(contract);
    }
}
