package by.morozmaksim.AgroTechCare.service;

import by.morozmaksim.AgroTechCare.domain.entity.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCare.web.dto.LegalEntityDto;

import java.util.List;

public interface LegalEntityService {

    LegalEntity update(LegalEntityDto legalEntityDto, Long id);

    void delete(Long id);

    LegalEntity findById(Long id);

    List<LegalEntity> findAll();
}
