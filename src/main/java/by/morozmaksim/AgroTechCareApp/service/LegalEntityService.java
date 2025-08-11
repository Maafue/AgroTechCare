package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;

import java.util.List;

public interface LegalEntityService {

    LegalEntity update(LegalEntityDto legalEntityDto);

    void delete(Long id);

    LegalEntity findById(Long id);

    List<LegalEntity> findAll();
}
