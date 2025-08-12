package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.entity.brand.Brand;
import by.morozmaksim.AgroTechCareApp.domain.exception.ResourceNotFoundException;
import by.morozmaksim.AgroTechCareApp.repository.BrandRepository;
import by.morozmaksim.AgroTechCareApp.service.BrandService;
import by.morozmaksim.AgroTechCareApp.web.dto.BrandDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(BrandDto brandDto) {
        Brand excistingBrand = findById(brandDto.getId());
        excistingBrand.setName(brandDto.getName());
        return brandRepository.save(excistingBrand);
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand not found with id " + id));
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Brand brand = findById(id);
        brandRepository.delete(brand);
    }
}
