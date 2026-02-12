package by.morozmaksim.AgroTechCare.service;

import by.morozmaksim.AgroTechCare.domain.entity.technique.Technique;
import by.morozmaksim.AgroTechCare.web.dto.TechniqueDto;

import java.util.List;

public interface TechniqueService {

    Technique create(Technique technique, Long brandId);

    Technique update(TechniqueDto techniqueDto, Long id);

    void delete(Long id);

    Technique findById(Long id);

    List<Technique> findAll();

}
