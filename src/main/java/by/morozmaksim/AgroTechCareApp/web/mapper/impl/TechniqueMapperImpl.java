package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.web.dto.TechniqueDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.BrandMapper;
import by.morozmaksim.AgroTechCareApp.web.mapper.TechniqueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TechniqueMapperImpl implements TechniqueMapper {

    private final BrandMapper brandMapper;

    @Override
    public TechniqueDto toDto(Technique technique) {
        if (technique == null) return null;

        TechniqueDto techniqueDto = new TechniqueDto();
        techniqueDto.setId(technique.getId());
        techniqueDto.setName(technique.getName());
        techniqueDto.setVin(technique.getVin());
        techniqueDto.setGuarantee(technique.getGuarantee());
        if (technique.getBrand() != null) {
            techniqueDto.setBrand(brandMapper.toDto(technique.getBrand()));
            techniqueDto.setBrandId(technique.getBrand().getId());
        }
        return techniqueDto;
    }

    @Override
    public Technique toEntity(TechniqueDto techniqueDto, Brand brand) {
        if (techniqueDto == null) return null;
        Technique technique = new Technique();
        technique.setId(techniqueDto.getId());
        technique.setName(techniqueDto.getName());
        technique.setVin(techniqueDto.getVin());
        technique.setGuarantee(techniqueDto.getGuarantee());
        technique.setBrand(brand);
        return technique;
    }

    @Override
    public List<TechniqueDto> toDtos(List<Technique> techniques) {
        if (techniques == null) return null;
        List<TechniqueDto> techniqueDtos = new ArrayList<>();
        for (Technique technique : techniques) {
            techniqueDtos.add(toDto(technique));
        }
        return techniqueDtos;
    }
}
