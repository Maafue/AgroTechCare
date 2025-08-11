package by.morozmaksim.AgroTechCareApp.web.controller;

import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;
import by.morozmaksim.AgroTechCareApp.service.ContractService;
import by.morozmaksim.AgroTechCareApp.web.dto.ContractDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.ContractMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractMapper contractMapper;
    private final ContractService contractService;

    //Для каждого контроллера добавить обработку исключений, добавить валидацию в dto
    //кэширование

    @PostMapping
    public ContractDto create(@RequestBody ContractDto contractDto) {
        Contract contract = contractMapper.toEntity(contractDto);
        Contract createdContract = contractService.create(contract, contractDto.getUserId());
        return contractMapper.toDto(createdContract);
    }

    @PutMapping("/{id}")
    public ContractDto update(@PathVariable("id") Long id, @RequestBody ContractDto contractDto) {
        contractDto.setId(id);
        Contract updatedContract = contractService.update(contractDto);
        return contractMapper.toDto(updatedContract);
    }

    @GetMapping("/{id}")
    public ContractDto findById(@PathVariable Long id) {
        return contractMapper.toDto(contractService.findById(id));
    }

    @GetMapping
    public List<ContractDto> findAll() {
        List<Contract> contracts = contractService.findAll();
        return contractMapper.toDtos(contracts);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contractService.delete(id);
    }
}
