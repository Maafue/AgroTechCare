package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;
import by.morozmaksim.AgroTechCareApp.web.dto.ContractDto;

import java.util.List;

public interface ContractMapper {

    Contract toEntity(ContractDto contractDto);

    ContractDto toDto(Contract contract);

    List<ContractDto> toDtos(List<Contract> contracts);
}
