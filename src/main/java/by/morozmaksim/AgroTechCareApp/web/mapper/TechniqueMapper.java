package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.web.dto.TechniqueDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TechniqueMapper {

    TechniqueDto toDto(Technique technique);

    Technique toEntity(TechniqueDto techniqueDto);

    List<TechniqueDto> toDtos(List<Technique> techniques);
}
