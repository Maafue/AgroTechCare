package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;

public interface LegalEntityRepository {

    LegalEntity update(LegalEntity legalEntity);

    void delete(LegalEntity legalEntity);

    LegalEntity findById(Long id);
}
