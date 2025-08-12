package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.entity.brand.Brand;
import by.morozmaksim.AgroTechCareApp.web.dto.BrandDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDto toDto(Brand brand);

    Brand toEntity(BrandDto brandDto);

    List<BrandDto> toDtos(List<Brand> brands);

}
