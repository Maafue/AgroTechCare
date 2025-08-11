package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.web.dto.TechniqueDto;

import java.util.List;

public interface TechniqueService {

    Technique create(Technique technique, Long brandId);
    Technique update(TechniqueDto techniqueDto);
    void delete(Long id);
    Technique findById(Long id);
    List<Technique> findAll();
}
