package by.morozmaksim.AgroTechCare.web.mapper;

import by.morozmaksim.AgroTechCare.domain.entity.contract.Contract;
import by.morozmaksim.AgroTechCare.web.dto.ContractDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract toEntity(ContractDto contractDto);

    ContractDto toDto(Contract contract);

    List<ContractDto> toDtos(List<Contract> contracts);

}
