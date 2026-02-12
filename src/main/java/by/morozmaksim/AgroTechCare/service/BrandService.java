package by.morozmaksim.AgroTechCare.service;

import by.morozmaksim.AgroTechCare.domain.entity.brand.Brand;
import by.morozmaksim.AgroTechCare.web.dto.BrandDto;

import java.util.List;

public interface BrandService {

    Brand create(Brand brand);

    Brand update(BrandDto brandDto, Long id);

    Brand findById(Long id);

    List<Brand> findAll();

    void delete(Long id);

}
