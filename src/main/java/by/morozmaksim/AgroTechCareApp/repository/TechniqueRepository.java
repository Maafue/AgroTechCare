package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;

import java.util.List;

public interface TechniqueRepository {

    Technique create(Technique technique);
    Technique update(Technique technique);
    void delete(Technique technique);
    Technique findById(Long id);
    List<Technique> findAll();

}
