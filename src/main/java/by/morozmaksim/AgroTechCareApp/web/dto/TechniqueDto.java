package by.morozmaksim.AgroTechCareApp.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TechniqueDto {

    private Long id;
    private String name;
    private String vin;
    private LocalDateTime guarantee;
    private Long brandId;
    private BrandDto brand;

}
