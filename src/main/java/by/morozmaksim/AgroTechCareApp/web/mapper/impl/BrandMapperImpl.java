package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.web.dto.BrandDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.BrandMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public BrandDto toDto(Brand brand) {
        if (brand == null)
            return null;
        BrandDto brandDto = new BrandDto();
        brandDto.setId(brand.getId());
        brandDto.setName(brand.getName());
        return brandDto;
    }

    @Override
    public Brand toEntity(BrandDto brandDto) {
        if (brandDto == null)
            return null;
        Brand brand = new Brand();
        brand.setId(brandDto.getId());
        brand.setName(brandDto.getName());
        return brand;
    }

    @Override
    public List<BrandDto> toDtos(List<Brand> brands) {
        if (brands == null)
            return null;

        List<BrandDto> brandDtos = new ArrayList<>();
        for (Brand brand : brands){
            brandDtos.add(toDto(brand));
        }
        return brandDtos;
    }
}
