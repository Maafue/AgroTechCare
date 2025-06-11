package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;

import java.util.List;

public interface BrandService {

    Brand create(Brand brand);
    Brand update(Brand brand);
    Brand findById(Long id);
    List<Brand> findAll();
    void delete(Long id);

}
