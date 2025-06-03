package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.LegalEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class LegalEntityMapperImpl implements LegalEntityMapper {

    @Override
    public LegalEntity toEntity(LegalEntityDto legalEntityDto) {

        LegalEntity legalEntity = new LegalEntity();
        legalEntity.setId(legalEntityDto.getId());
        legalEntity.setName(legalEntityDto.getName());
        legalEntity.setInn(legalEntityDto.getInn());
        legalEntity.setAddress(legalEntityDto.getAddress());

        return legalEntity;
    }

    @Override
    public LegalEntityDto toDto(LegalEntity legalEntity) {
        if (legalEntity == null) {
            return null;
        }
        LegalEntityDto legalEntityDto = new LegalEntityDto();
        legalEntityDto.setId(legalEntity.getId());
        legalEntityDto.setName(legalEntity.getName());
        legalEntityDto.setInn(legalEntity.getInn());
        legalEntityDto.setAddress(legalEntity.getAddress());

        return legalEntityDto;
    }
}
