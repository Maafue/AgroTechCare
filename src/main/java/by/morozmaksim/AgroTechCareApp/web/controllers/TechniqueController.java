package by.morozmaksim.AgroTechCareApp.web.controllers;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.service.BrandService;
import by.morozmaksim.AgroTechCareApp.service.TechniqueService;
import by.morozmaksim.AgroTechCareApp.web.dto.TechniqueDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.TechniqueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/techniques")
public class TechniqueController {

    private final TechniqueService techniqueService;
    private final TechniqueMapper techniqueMapper;
    private final BrandService brandService;

    @PostMapping
    public TechniqueDto create(@RequestBody TechniqueDto techniqueDto) {
        Brand brand = brandService.findById(techniqueDto.getBrandId());
        Technique technique = techniqueMapper.toEntity(techniqueDto, brand);
        Technique createdTechnique = techniqueService.create(technique);
        return techniqueMapper.toDto(createdTechnique);
    }
    @PutMapping
    public TechniqueDto update(@RequestBody TechniqueDto techniqueDto) {
        Brand brand = brandService.findById(techniqueDto.getBrandId());
        Technique technique = techniqueMapper.toEntity(techniqueDto, brand);
        Technique updatedTechnique = techniqueService.update(technique);
        return techniqueMapper.toDto(updatedTechnique);
    }
    @GetMapping("/{id}")
    public TechniqueDto findById(@PathVariable Long id) {
        Technique technique = techniqueService.findById(id);
        return techniqueMapper.toDto(technique);
    }
    @GetMapping
    public List<TechniqueDto> findAll() {
        List<Technique> techniques = techniqueService.findAll();
        return techniqueMapper.toDtos(techniques);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        techniqueService.delete(id);
    }
}
