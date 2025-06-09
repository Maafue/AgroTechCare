package by.morozmaksim.AgroTechCareApp.dao;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;

public interface LegalEntityDao {

    LegalEntity update(LegalEntity legalEntity);

    void delete(LegalEntity legalEntity);

    LegalEntity findById(Long id);
}
