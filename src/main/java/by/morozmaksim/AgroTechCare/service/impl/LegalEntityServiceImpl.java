package by.morozmaksim.AgroTechCare.service.impl;

import by.morozmaksim.AgroTechCare.domain.exception.ResourceNotFoundException;
import by.morozmaksim.AgroTechCare.domain.entity.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCare.repository.LegalEntityRepository;
import by.morozmaksim.AgroTechCare.service.LegalEntityService;
import by.morozmaksim.AgroTechCare.web.dto.LegalEntityDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LegalEntityServiceImpl implements LegalEntityService {

    private final LegalEntityRepository legalEntityRepository;

    @Override
    public LegalEntity update(LegalEntityDto legalEntityDto, Long id) {
        LegalEntity excistingLegalEntity = findById(id);
        excistingLegalEntity.setName(legalEntityDto.getName());
        excistingLegalEntity.setAddress(legalEntityDto.getAddress());
        excistingLegalEntity.setInn(legalEntityDto.getInn());
        return legalEntityRepository.save(excistingLegalEntity);
    }

    @Override
    public LegalEntity findById(Long id) {
        return legalEntityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Legal entity not found with id " + id));
    }

    @Override
    public List<LegalEntity> findAll() {
        return legalEntityRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        LegalEntity legalEntity = findById(id);
        legalEntityRepository.delete(legalEntity);
    }
}
