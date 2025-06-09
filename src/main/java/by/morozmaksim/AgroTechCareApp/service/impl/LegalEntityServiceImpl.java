package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.dao.LegalEntityDao;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LegalEntityServiceImpl implements LegalEntityService {

    private final LegalEntityDao legalEntityDao;

    @Override
    public LegalEntity update(LegalEntity legalEntity) {
        return legalEntityDao.update(legalEntity);
    }

    @Override
    public LegalEntity findById(Long id) {
        return legalEntityDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        legalEntityDao.delete(findById(id));
    }
}
