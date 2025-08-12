package by.morozmaksim.AgroTechCareApp.web.controller;

import by.morozmaksim.AgroTechCareApp.domain.entity.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.LegalEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/legal_entity")
@RequiredArgsConstructor
public class LegalEntityController {

    private final LegalEntityMapper legalEntityMapper;
    private final LegalEntityService legalEntityService;

    //Для каждого контроллера добавить обработку исключений, добавить валидацию в dto
    //кэширование

    @PutMapping("/{id}")
    public LegalEntityDto update(@PathVariable Long id,
                                 @Validated @RequestBody LegalEntityDto legalEntityDto) {
        legalEntityDto.setId(id);
        LegalEntity updatedLegalEntity = legalEntityService.update(legalEntityDto);
        return legalEntityMapper.toDto(updatedLegalEntity);
    }

    @GetMapping("/{id}")
    public LegalEntityDto getById(@PathVariable Long id) {
        LegalEntity legalEntity = legalEntityService.findById(id);
        return legalEntityMapper.toDto(legalEntity);
    }

    @GetMapping
    public List<LegalEntityDto> getAll() {
        List<LegalEntity> legalEntities = legalEntityService.findAll();
        return legalEntityMapper.toDtos(legalEntities);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        legalEntityService.delete(id);
    }

}
