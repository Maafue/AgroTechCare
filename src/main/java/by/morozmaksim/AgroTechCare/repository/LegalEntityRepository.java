package by.morozmaksim.AgroTechCare.repository;

import by.morozmaksim.AgroTechCare.domain.entity.legalEntity.LegalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalEntityRepository extends JpaRepository<LegalEntity, Long> {
}
