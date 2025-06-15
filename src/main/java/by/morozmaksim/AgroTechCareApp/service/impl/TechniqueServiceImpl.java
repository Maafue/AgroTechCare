package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.repository.BrandRepository;
import by.morozmaksim.AgroTechCareApp.repository.TechniqueRepository;
import by.morozmaksim.AgroTechCareApp.service.TechniqueService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TechniqueServiceImpl implements TechniqueService {

    private final TechniqueRepository techniqueRepository;
    private final BrandRepository brandRepository;

    @Override
    public Technique create(Technique technique, Long brandId) {
        Brand brand = brandRepository.findById(brandId);
        technique.setBrand(brand);
        return techniqueRepository.create(technique);
    }

    @Override
    public Technique update(Technique technique, Long brandId) {
        Brand brand = brandRepository.findById(brandId);
        technique.setBrand(brand);
        return techniqueRepository.update(technique);
    }

    @Override
    public void delete(Long id) {
        Technique technique = findById(id);
        techniqueRepository.delete(technique);
    }

    @Override
    public Technique findById(Long id) {
        return techniqueRepository.findById(id);
    }

    @Override
    public List<Technique> findAll() {
        return techniqueRepository.findAll();
    }
}
