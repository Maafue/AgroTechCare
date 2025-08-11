package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechniqueRepository extends JpaRepository<Technique, Long> {

}
