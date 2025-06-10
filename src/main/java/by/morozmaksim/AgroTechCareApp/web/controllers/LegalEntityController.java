package by.morozmaksim.AgroTechCareApp.web.controllers;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.LegalEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/legal_entity")
@RequiredArgsConstructor
public class LegalEntityController {

    private final LegalEntityMapper legalEntityMapper;
    private final LegalEntityService legalEntityService;

    //Для каждого контроллера добавить обработку исключений, добавить валидацию в dto
    //кэширование

    @PutMapping
    public LegalEntityDto update(@RequestBody LegalEntityDto legalEntityDto) {
        LegalEntity legalEntity = legalEntityMapper.toEntity(legalEntityDto);
        LegalEntity updatedLegalEntity = legalEntityService.update(legalEntity);
        return legalEntityMapper.toDto(updatedLegalEntity);
    }

    @GetMapping("/{id}")
    public LegalEntityDto getById(@PathVariable Long id) {
        LegalEntity legalEntity = legalEntityService.findById(id);
        return legalEntityMapper.toDto(legalEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        legalEntityService.delete(id);
    }
}
