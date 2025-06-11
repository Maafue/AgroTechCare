package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.web.dto.BrandDto;

import java.util.List;

public interface BrandMapper {

    BrandDto toDto(Brand brand);

    Brand toEntity(BrandDto brandDto);

    List<BrandDto> toDtos(List<Brand> brands);

}
