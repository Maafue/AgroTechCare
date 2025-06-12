package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.repository.TechniqueRepository;
import by.morozmaksim.AgroTechCareApp.service.TechniqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechniqueServiceImpl implements TechniqueService {

    private final TechniqueRepository techniqueRepository;

    @Override
    public Technique create(Technique technique) {
        return techniqueRepository.create(technique);
    }

    @Override
    public Technique update(Technique technique) {
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
