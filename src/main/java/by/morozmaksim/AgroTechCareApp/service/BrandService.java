package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.web.dto.BrandDto;

import java.util.List;

public interface BrandService {

    Brand create(Brand brand);
    Brand update(BrandDto brandDto);
    Brand findById(Long id);
    List<Brand> findAll();
    void delete(Long id);

}
