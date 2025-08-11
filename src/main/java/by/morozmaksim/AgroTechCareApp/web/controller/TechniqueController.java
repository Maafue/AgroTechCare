package by.morozmaksim.AgroTechCareApp.web.controller;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
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

    @PostMapping
    public TechniqueDto create(@RequestBody TechniqueDto techniqueDto) {
        Technique technique = techniqueMapper.toEntity(techniqueDto);
        Technique createdTechnique = techniqueService.create(technique, techniqueDto.getBrandId());
        return techniqueMapper.toDto(createdTechnique);
    }
    @PutMapping("/{id}")
    public TechniqueDto update(@PathVariable("id") Long id,
                               @RequestBody TechniqueDto techniqueDto) {
        techniqueDto.setId(id);
        Technique updatedTechnique = techniqueService.update(techniqueDto);
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
