package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;

import java.util.List;

public interface BrandRepository {

    Brand create(Brand brand);
    Brand update(Brand brand);
    Brand findById(Long id);
    List<Brand> findAll();
    void delete(Brand brand);

}
