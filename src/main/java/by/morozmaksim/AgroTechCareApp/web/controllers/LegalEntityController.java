package by.morozmaksim.AgroTechCareApp.web.controllers;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.LegalEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/legal_entity")
@RequiredArgsConstructor
public class LegalEntityController {

    private final LegalEntityMapper legalEntityMapper;
    private final LegalEntityService legalEntityService;

    @PutMapping
    public LegalEntityDto update(@RequestBody LegalEntityDto legalEntityDto) {
        LegalEntity legalEntity = legalEntityMapper.toEntity(legalEntityDto);
        LegalEntity updatedLegalEntity = legalEntityService.update(legalEntity);
        return legalEntityMapper.toDto(updatedLegalEntity);
    }
}
