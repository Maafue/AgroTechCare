package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.repository.LegalEntityRepository;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LegalEntityServiceImpl implements LegalEntityService {

    private final LegalEntityRepository legalEntityRepository;

    @Override
    public LegalEntity update(LegalEntity legalEntity) {
        return legalEntityRepository.update(legalEntity);
    }

    @Override
    public LegalEntity findById(Long id) {
        return legalEntityRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        legalEntityRepository.delete(findById(id));
    }
}
