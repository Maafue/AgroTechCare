package by.morozmaksim.AgroTechCareApp.web.controllers;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.service.BrandService;
import by.morozmaksim.AgroTechCareApp.web.dto.BrandDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
    private final BrandMapper brandMapper;

    //Для каждого контроллера добавить обработку исключений, добавить валидацию в dto
    //кэширование

    @PostMapping
    public BrandDto toDto(@RequestBody BrandDto brandDto) {
        Brand brand = brandMapper.toEntity(brandDto);
        brandService.create(brand);
        return brandMapper.toDto(brand);
    }
    @PutMapping
    public BrandDto update(@RequestBody BrandDto brandDto) {
        Brand brand = brandMapper.toEntity(brandDto);
        brandService.update(brand);
        return brandMapper.toDto(brand);
    }
    @GetMapping("/{id}")
    public BrandDto getById(@PathVariable Long id) {
        Brand brand = brandService.findById(id);
        return brandMapper.toDto(brand);
    }
    @GetMapping
    public List<BrandDto> getAll() {
        List<Brand> brands = brandService.findAll();
        return brandMapper.toDtos(brands);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        brandService.delete(id);
    }

}
