package by.morozmaksim.AgroTechCare.web.mapper;

import by.morozmaksim.AgroTechCare.domain.entity.technique.Technique;
import by.morozmaksim.AgroTechCare.web.dto.TechniqueDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TechniqueMapper {

    TechniqueDto toDto(Technique technique);

    Technique toEntity(TechniqueDto techniqueDto);

    List<TechniqueDto> toDtos(List<Technique> techniques);

}
