package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;

import java.util.List;

public interface TechniqueService {

    Technique create(Technique technique, Long brandId);
    Technique update(Technique technique, Long brandId);
    void delete(Long id);
    Technique findById(Long id);
    List<Technique> findAll();
}
