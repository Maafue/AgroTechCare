package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;
import by.morozmaksim.AgroTechCareApp.web.dto.ContractDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.ContractMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractMapperImpl implements ContractMapper {

    @Override
    public Contract toEntity(ContractDto contractDto) {
        if (contractDto == null) return null;
        Contract contract = new Contract();
        contract.setId(contractDto.getId());
        contract.setNumber(contractDto.getNumber());
        contract.setDate(contractDto.getDate());
        contract.setEndDate(contractDto.getEndDate());
        contract.setPrepayment(contractDto.getPrepayment());
        contract.setDebt(contractDto.getDebt());
        contract.setOverdueDebt(contractDto.getOverdueDebt());
        return contract;
    }

    @Override
    public ContractDto toDto(Contract contract) {
        if (contract == null) return null;
        ContractDto contractDto = new ContractDto();
        contractDto.setId(contract.getId());
        contractDto.setNumber(contract.getNumber());
        contractDto.setDate(contract.getDate());
        contractDto.setEndDate(contract.getEndDate());
        contractDto.setPrepayment(contract.getPrepayment());
        contractDto.setDebt(contract.getDebt());
        contractDto.setOverdueDebt(contract.getOverdueDebt());
        if (contract.getUser() != null) {
            contractDto.setUserId(contract.getUser().getId());
        }
        return contractDto;
    }

    @Override
    public List<ContractDto> toDtos(List<Contract> contracts) {

        if (contracts == null) return null;
        List<ContractDto> contractDtos = new ArrayList<>();
        for (Contract contract : contracts) {
            contractDtos.add(toDto(contract));
        }
        return contractDtos;
    }
}