package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.exception.ResourceNotFoundException;
import by.morozmaksim.AgroTechCareApp.repository.LegalEntityRepository;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class LegalEntityServiceImpl implements LegalEntityService {

    private final LegalEntityRepository legalEntityRepository;

    @Override
    public LegalEntity update(LegalEntity legalEntity) {
        return legalEntityRepository.save(legalEntity);
    }

    @Override
    public LegalEntity findById(Long id) {
        return legalEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Legal entity not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        LegalEntity legalEntity = findById(id);
        legalEntityRepository.delete(legalEntity);
    }
}
