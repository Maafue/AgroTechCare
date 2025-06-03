package by.morozmaksim.AgroTechCareApp.dao.impl;

import by.morozmaksim.AgroTechCareApp.dao.LegalEntityDao;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import org.springframework.stereotype.Repository;

@Repository
public class LegalEntityDaoImpl implements LegalEntityDao {

    @Override
    public LegalEntity update(LegalEntity legalEntity) {
        return legalEntity;
    }
}
