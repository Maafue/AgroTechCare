package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;

public interface LegalEntityMapper {

    LegalEntity toEntity(LegalEntityDto legalEntityDto);

    LegalEntityDto toDto(LegalEntity legalEntity);

}
