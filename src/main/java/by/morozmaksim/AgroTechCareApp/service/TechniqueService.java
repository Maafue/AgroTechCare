package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;

import java.util.List;

public interface TechniqueService {

    Technique create(Technique technique);
    Technique update(Technique technique);
    void delete(Long id);
    Technique findById(Long id);
    List<Technique> findAll();
}
