package by.morozmaksim.AgroTechCare.web.mapper;

import by.morozmaksim.AgroTechCare.domain.entity.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCare.web.dto.LegalEntityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LegalEntityMapper {

    LegalEntity toEntity(LegalEntityDto legalEntityDto);

    LegalEntityDto toDto(LegalEntity legalEntity);

    List<LegalEntityDto> toDtos(List<LegalEntity> legalEntities);

}
