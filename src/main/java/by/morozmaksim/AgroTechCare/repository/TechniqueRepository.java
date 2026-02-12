package by.morozmaksim.AgroTechCare.repository;

import by.morozmaksim.AgroTechCare.domain.entity.technique.Technique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechniqueRepository extends JpaRepository<Technique, Long> {
}
