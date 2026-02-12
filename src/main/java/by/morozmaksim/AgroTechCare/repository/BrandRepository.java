package by.morozmaksim.AgroTechCare.repository;

import by.morozmaksim.AgroTechCare.domain.entity.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
