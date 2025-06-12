package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.web.dto.TechniqueDto;

import java.util.List;

public interface TechniqueMapper {

    TechniqueDto toDto(Technique technique);

    Technique toEntity(TechniqueDto techniqueDto, Brand brand);
    List<TechniqueDto> toDtos(List<Technique> techniques);
}
