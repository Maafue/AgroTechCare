package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;

public interface LegalEntityService {

    LegalEntity update(LegalEntity legalEntity);

    void delete(Long id);

    LegalEntity findById(Long id);
}
